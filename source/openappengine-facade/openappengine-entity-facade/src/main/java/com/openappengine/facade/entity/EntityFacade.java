/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;
import java.util.Map;

import com.openappengine.facade.entity.definition.EntityDefinition;

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
	
	/**
	 * @param entityName
	 * @param id
	 * @return
	 */
	EntityValue createEntityValue(String entityName,Serializable id);
	
	/**
	 * @param entityName
	 * @param parameters
	 * @return
	 */
	public EntityValue createEntityValue(String entityName,Map<String,Object> parameters);
	
	/**
	 * Save {@link EntityValue}.
	 * @param entityValue
	 * @return
	 */
	Serializable saveEntityValue(EntityValue entityValue);

}
