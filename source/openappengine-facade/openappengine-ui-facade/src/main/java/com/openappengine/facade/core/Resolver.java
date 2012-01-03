/**
 * 
 */
package com.openappengine.facade.core;

/**
 * This is a root interface for all the Resolver i.e. Values/Entities etc.
 * 
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public interface Resolver {

	/**
	 * Resolve the name to a value.
	 * @param name
	 * @return
	 */
	Object resolve(String name);
	
}
