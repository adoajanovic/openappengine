/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.EntityDefinitionCache;
import com.openappengine.facade.entity.definition.FieldDefinition;
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
	    EntityValue entityValue = createEntityValue(entityName);
	    if(id != null) {
		    Session session = hibernateTemplate.getSessionFactory().openSession();
        	Object attachedInstance = hibernateTemplate.load(entityValue.getEntityDefinition().getEntityClass(),id);
        	entityValue.setInstance(attachedInstance);
        	session.flush();
	    }
	    return entityValue;
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
