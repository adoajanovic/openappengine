/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import org.springframework.core.io.Resource;

/**
 * The Factory is initialized from the listener and 
 * the same instance of this factory is queried for loading subsequent screens.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ScreenApplicationContextFactory {
	
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

}
