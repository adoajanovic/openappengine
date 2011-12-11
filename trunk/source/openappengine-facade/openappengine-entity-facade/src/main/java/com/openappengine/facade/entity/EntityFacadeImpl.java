/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.EntityDefinitionCache;
import com.openappengine.utility.UtilLogger;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeImpl implements EntityFacade {
	
	private EntityDefinitionCache entityDefinitionCache;
	
	private HibernateTemplate hibernateTemplate;
	
	private UtilLogger logger = new UtilLogger(getClass());
	
	/* (non-Javadoc)
	 * @see com.openappengine.facade.entity.EntityFacade#createEntityValue(java.lang.String)
	 */
	public EntityValue createEntityValue(String entityName) {
		EntityDefinition entityDefinition = findEntityDefinition(entityName);
		Class<?> entityClass = entityDefinition.getEntityClass();
		EntityValue entityValue = new EntityFacadeDelegator().createEntityValue(entityName,entityDefinition,entityClass);
		return entityValue;
	}
	
	public Serializable saveEntityValue(EntityValue entityValue) {
	    if(entityValue == null || entityValue.getInstance() == null) {
		logger.logDebug("EntityValue found null. EntityValue cannot be persisted.");
		return null;
	    }
	    logger.logDebug("Persisting EntityValue :" + entityValue.getEntityName());
	    return hibernateTemplate.save(entityValue.getInstance());
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
