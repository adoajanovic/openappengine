/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.apache.commons.collections.Factory;
import org.springframework.core.io.Resource;

import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * The Factory is initialized from the listener and 
 * the same instance of this factory is queried for loading subsequent screens.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ScreenApplicationContextFactory extends Factory {
	
	/**
	 * Is the Screen at the given resournce present in the factory.
	 * @param resource
	 * @return
	 */
	boolean contains(Resource resource);
	
	/**
	 * Get ScreenApplicationContext from the factory.
	 * @param resource
	 * @return
	 */
	ScreenApplicationContext getScreenApplicationContext(Resource resource);
	
	/**
	 * Register the ScreenApplicationContext with the factory.
	 * @param resource
	 * @param context
	 */
	void registerScreenApplicationContext(Resource resource,ScreenApplicationContext context);

	/**
	 * Create a ScreenApplicationContext object
	 */
	ScreenApplicationContext create();
	
}
