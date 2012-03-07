/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.classic.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.w3c.dom.Document;

import com.openappengine.entity.definition.Entity;
import com.openappengine.entity.definition.EntityDefinitionCache;
import com.openappengine.entity.delegator.Delegator;
import com.openappengine.entity.request.EntityRequest;
import com.openappengine.entity.response.DefaultEntityResponse;
import com.openappengine.entity.response.EntityResponse;
import com.openappengine.model.code.CodeType;
import com.openappengine.utility.ObjectConverter;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityEngineFacadeImpl implements EntityEngineFacade {
	
	private EntityDefinitionCache entityDefinitionCache;
	
	private HibernateTemplate hibernateTemplate;
	
	private Delegator delegator;
	
	private Logger logger = Logger.getLogger("EntityEngine");
	
	public EntityResponse createEntityValue(String entityName) {
		EntityValue entityValue = createPojoEntityValue(entityName);
		DefaultEntityResponse response = new DefaultEntityResponse();
		response.addEntity(entityValue.getEntityDefinition());
		return response;
	}
	
	@Transactional
	public EntityResponse saveEntityValueInstance(EntityRequest entityRequest) {
		
		return null;
	}
	
	public Document makeValueEntityAsXml(String entityName,Map<String, Object> values) {
		return delegator.makeValueEntityAsXml(entityName, values);
	}
	
	public Document makeValueEntityAsXml(String entityName) {
		return delegator.makeValueEntityAsXml(entityName);
	}
	
	public EntityValue createEntityValue(String entityName, boolean isXml) {
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName needed for creating Entity. Found null or blank.");
		}
		
		EntityValue entityValue;
		if(isXml) {
			entityValue = createXmlEntityValue(entityName);
		} else {
			entityValue = createPojoEntityValue(entityName);
		}
		return entityValue;
	}
	
	public EntityValue createXmlEntityValue(String entityName) {
		Entity entityDefinition = findEntityDefinition(entityName);
		EntityValue entityValue;
		Document entityDoc = entityDefinition.getDocument();
		entityValue = new XmlEntityValue(entityDoc, entityName, entityDefinition);
		return entityValue;
	}
	
	public EntityValue createPojoEntityValue(String entityName) {
		Entity entityDefinition = findEntityDefinition(entityName);
		EntityValue entityValue;
		Class<?> entityClass = entityDefinition.getEntityClass();
		entityValue = new EntityFacadeDelegator().createEntityValue(entityName,entityDefinition,entityClass);
		return entityValue;
	}
	
	public EntityValue createEntityValue(String entityName,Serializable id) {
	    //PojoEntityValue entityValue = createEntityValue(entityName);
	    if(id != null) {
		    Session session = hibernateTemplate.getSessionFactory().openSession();
        	Object attachedInstance = hibernateTemplate.load(CodeType.class,id);
        	Entity entityDefinition = findEntityDefinition(entityName);
        	EntityValue pojoEntityValue = new PojoEntityValue(entityName,entityDefinition,attachedInstance);
			session.flush();
			return pojoEntityValue;
	    }
		return null;
	}
	
	public List<EntityValue> findEntityValues(String entityName,Map<String,Object> parameters) {
	    EntityValue pojoEntityValue = createEntityValue(entityName, false);
	    Entity entityDefinition = pojoEntityValue.getEntityDefinition();
	    Class<?> entityClass = entityDefinition.getEntityClass();
		List list = findByPropertyValues(entityClass, parameters);
	    
	    List<EntityValue> pojoEntityValues = new ArrayList<EntityValue>();
	    if(list != null && !list.isEmpty()) {
	    	for(Object object : list) {
	    		pojoEntityValue = createEntityValue(entityName, false);
	    		pojoEntityValue.setInstance(object);
	    		pojoEntityValues.add(pojoEntityValue);
	    	}
	    }
	    return pojoEntityValues;
	}
	
	public EntityValue findUniqueEntityValue(String entityName,Map<String,Object> parameters) {
		if(parameters == null || parameters.isEmpty()) {
			logger.error("No parameters passed for finding PojoEntityValue. Cannot find a unique PojoEntityValue instance.");
			return null;			
		}
	    Entity entityDefinition = findEntityDefinition(entityName);
	    EntityValue pojoEntityValue = null;
	    Class<?> entityClass = entityDefinition.getEntityClass();
	    List list = findByPropertyValues(entityClass, parameters);
	    if(list != null && !list.isEmpty()) {
	    	Object instance = list.get(0);
        	pojoEntityValue = new PojoEntityValue(entityName,entityDefinition,instance);
	    }
	    return pojoEntityValue;
	}
	
	public Serializable findOneByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException, EntityValueFindException {
		List list = findByPropertyValues(entityClass, parameters);
		
		if(list == null || list.isEmpty()) {
			return null;
		}
		
		if(list != null && list.size() != 1) {
			logger.error("Cannot find a unique PojoEntityValue.");
			throw new EntityValueFindException("Multiple instances found for the PojoEntityValue.");
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
	public EntityValue saveEntityValue(EntityValue pojoEntityValue) {
	    Object instance = pojoEntityValue.getInstance();
		if(pojoEntityValue == null || instance == null) {
		logger.debug("PojoEntityValue found null. PojoEntityValue cannot be persisted.");
		return null;
	    }
	    logger.debug("Persisting PojoEntityValue :" + pojoEntityValue.getEntityName());
	    hibernateTemplate.save(instance);
	    pojoEntityValue.setInstance(instance);
	    return pojoEntityValue;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteEntityValue(EntityValue pojoEntityValue) {
		Object instance = pojoEntityValue.getInstance();
		if(pojoEntityValue == null || instance == null) {
			logger.debug("PojoEntityValue found null. PojoEntityValue cannot be deleted.");
			return false;
	    }
		
		hibernateTemplate.delete(instance);
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public EntityValue saveOrUpdateEntityValue(EntityValue pojoEntityValue) {
	    Object instance = pojoEntityValue.getInstance();
		if(pojoEntityValue == null || instance == null) {
		logger.debug("PojoEntityValue found null. PojoEntityValue cannot be persisted.");
		return null;
	    }
	    logger.debug("Persisting PojoEntityValue :" + pojoEntityValue.getEntityName());
	    hibernateTemplate.saveOrUpdate(instance);
	    pojoEntityValue.setInstance(instance);
	    return pojoEntityValue;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.entity.EntityEngineFacade#findEntityDefinition(java.lang.String)
	 */
	public Entity findEntityDefinition(String entityName) {
		Entity entityDefinition = entityDefinitionCache.getEntityDefinition(entityName);
		return entityDefinition;
	}
	
	public void setEntityDefinitionCache(EntityDefinitionCache entityDefinitionCache) {
		this.entityDefinitionCache = entityDefinitionCache;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	    this.hibernateTemplate = hibernateTemplate;
	}

	public void setDelegator(Delegator delegator) {
		this.delegator = delegator;
	}

}
