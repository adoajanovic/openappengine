/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.classic.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.EntityDefinitionCache;
import com.openappengine.facade.entity.exception.EntityValueException;
import com.openappengine.facade.entity.utils.ObjectConverter;
import com.openappengine.model.code.CodeType;
import com.openappengine.utility.UtilLogger;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeImpl implements EntityFacade {
	
	private EntityDefinitionCache entityDefinitionCache;
	
	private HibernateTemplate hibernateTemplate;
	
	private UtilLogger logger = new UtilLogger(getClass());
	
	public EntityValue createEntityValue(String entityName) {
		EntityDefinition entityDefinition = findEntityDefinition(entityName);
		Class<?> entityClass = entityDefinition.getEntityClass();
		EntityValue entityValue = new EntityFacadeDelegator().createEntityValue(entityName,entityDefinition,entityClass);
		return entityValue;
	}
	
	public EntityValue createEntityValue(String entityName,Serializable id) {
	    //EntityValue entityValue = createEntityValue(entityName);
	    if(id != null) {
		    Session session = hibernateTemplate.getSessionFactory().openSession();
        	Object attachedInstance = hibernateTemplate.load(CodeType.class,id);
        	EntityDefinition entityDefinition = findEntityDefinition(entityName);
        	EntityValue entityValue = new EntityValue(entityName,entityDefinition,attachedInstance);
			session.flush();
			return entityValue;
	    }
		return null;
	}
	
	public List<EntityValue> findEntityValues(String entityName,Map<String,Object> parameters) {
	    EntityValue entityValue = createEntityValue(entityName);
	    EntityDefinition entityDefinition = entityValue.getEntityDefinition();
	    Class<?> entityClass = entityDefinition.getEntityClass();
		List list = findByPropertyValues(entityClass, parameters);
	    
	    List<EntityValue> entityValues = new ArrayList<EntityValue>();
	    if(list != null && !list.isEmpty()) {
	    	for(Object object : list) {
	    		entityValue = createEntityValue(entityName);
	    		entityValue.setInstance(object);
	    		entityValues.add(entityValue);
	    	}
	    }
	    return entityValues;
	}
	
	public EntityValue findUniqueEntityValue(String entityName,Map<String,Object> parameters) {
	    EntityDefinition entityDefinition = findEntityDefinition(entityName);
	    EntityValue entityValue = null;
	    Class<?> entityClass = entityDefinition.getEntityClass();
	    List list = findByPropertyValues(entityClass, parameters);
	    if(list != null && !list.isEmpty()) {
	    	Object instance = list.get(0);
        	entityValue = new EntityValue(entityName,entityDefinition,instance);
	    }
	    return entityValue;
	}
	
	public Serializable findOneByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException {
		List list = findByPropertyValues(entityClass, parameters);
		if(list != null && list.size() != 1) {
			//TODO
		} 
		
		return (Serializable) list.get(0);
	}

	/**
	 * @param entityName
	 * @param parameters
	 * @return
	 * @throws DataAccessException
	 */
	public List findByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException {
	    StringBuffer hql = new StringBuffer("from " + entityClass.getSimpleName());
	    List list;
	    if(parameters != null && !parameters.isEmpty()) {
	    	hql.append(" where ");
	    	Set<String> params = parameters.keySet();
	    	List<String> paramList = new ArrayList<String>();
	    	List<Object> valueList = new ArrayList<Object>();
	    	
	    	Iterator<String> iterator = params.iterator();
	    	boolean hasNext = iterator.hasNext();
	    	while(hasNext) {
	    		String param = iterator.next();
	    		
	    		Field field = ReflectionUtils.findField(entityClass, param);
	    		if(field != null) {
		    		Class<?> type = field.getType();
		    		
		    		if(type.isPrimitive()) {
		    			if(type.getName().equals("int")) {
		    				type = Integer.class;
		    			} else if(type.getName().equals("long")) {
		    				type = Long.class;
		    			} else if(type.getName().equals("double")) {
		    				type = Double.class;
		    			} else if(type.getName().equals("boolean")) {
		    				type = Boolean.class;
		    			}
		    			//TODO - Add more primitive types here.
		    		}
		    		Object from = parameters.get(param);
		    		
					Object paramValue = ObjectConverter.convert(from, type);
					
					paramList.add(param);
		    		valueList.add(paramValue);
		    		
		    		//TODO - Make Configurable by changing = with an operator and allowing any criteria.
					hql.append(param + "=" + ":" + param);
					
					hasNext = iterator.hasNext();
					if(hasNext) {
						hql.append(" and ");
					}
	    		}
	    	}
	    	list = hibernateTemplate.findByNamedParam(hql.toString(), paramList.toArray(new String[0]), valueList.toArray());
	    } else {
	    	list = hibernateTemplate.find(hql.toString());
	    }
		return list;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public EntityValue saveEntityValue(EntityValue entityValue) {
	    Object instance = entityValue.getInstance();
		if(entityValue == null || instance == null) {
		logger.logDebug("EntityValue found null. EntityValue cannot be persisted.");
		return null;
	    }
	    logger.logDebug("Persisting EntityValue :" + entityValue.getEntityName());
	    hibernateTemplate.saveOrUpdate(instance);
	    entityValue.setInstance(instance);
	    return entityValue;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.entity.EntityFacade#findEntityDefinition(java.lang.String)
	 */
	public EntityDefinition findEntityDefinition(String entityName) {
		EntityDefinition entityDefinition = entityDefinitionCache.getEntityDefinition(entityName);
		return entityDefinition;
	}
	
	public void setEntityDefinitionCache(EntityDefinitionCache entityDefinitionCache) {
		this.entityDefinitionCache = entityDefinitionCache;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	    this.hibernateTemplate = hibernateTemplate;
	}

}
