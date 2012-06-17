/**
 * 
 */
package com.openappengine.entity;

import com.openappengine.entity.definition.Entity;

/**
 * @author hrishikesh.joshi
 * @since  Feb 6, 2012
 *
 */
public interface EntityValue {
	
	String getEntityName();
	
	Object getInstance();
	
	void setInstance(Object value);
	
	Entity getEntityDefinition();

}
