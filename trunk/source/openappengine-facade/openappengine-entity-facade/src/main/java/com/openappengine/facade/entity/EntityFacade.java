/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.api.EntityDefinition;

/**
 * @author hrishikesh.joshi
 *
 */
public interface EntityFacade {
	
	
	/**
	 * @param entityName
	 * @return finds a EntityDefinition instance for the given entity name.
	 */
	EntityDefinition findEntityDefinition(String entityName);
	
	/**
	 * @param entityName
	 * @return A transient EntityValue instance.
	 */
	EntityValue createEntityValue(String entityName);
	
	

}
