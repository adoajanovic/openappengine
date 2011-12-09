/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.EntityDefinitionCache;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeImpl implements EntityFacade {
	
	private EntityDefinitionCache entityDefinitionCache;
	
	/* (non-Javadoc)
	 * @see com.openappengine.facade.entity.EntityFacade#createEntityValue(java.lang.String)
	 */
	public EntityValue createEntityValue(String entityName) {
		EntityDefinition entityDefinition = findEntityDefinition(entityName);
		Class entityClass = entityDefinition.getEntityClass();
		EntityValue entityValue = new EntityFacadeDelegator().createEntityValue(entityClass);
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

}
