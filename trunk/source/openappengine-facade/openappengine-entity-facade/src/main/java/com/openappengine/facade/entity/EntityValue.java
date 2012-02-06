/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.definition.EntityDefinition;

/**
 * @author hrishikesh.joshi
 * @since  Feb 6, 2012
 *
 */
public interface EntityValue {
	
	String getEntityName();
	
	Object getInstance();
	
	void setInstance(Object value);
	
	EntityDefinition getEntityDefinition();

}
