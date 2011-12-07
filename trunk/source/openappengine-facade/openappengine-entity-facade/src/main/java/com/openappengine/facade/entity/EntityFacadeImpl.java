/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.api.EntityDefinition;

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
		String entityClassName = entityDefinition.getEntityClassName();
		EntityDataHolder entityDataHolder = new EntityFacadeDelegator().createNewEntityDataHolder(entityClassName);
		return new EntityValue(entityDataHolder);
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
