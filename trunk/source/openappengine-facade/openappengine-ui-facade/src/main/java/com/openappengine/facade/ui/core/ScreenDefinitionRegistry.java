/**
 * 
 */
package com.openappengine.facade.ui.core;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishikesh.joshi
 * @since Dec 27, 2011
 */
public interface ScreenDefinitionRegistry {
	
	/**
	 * Register the Screen Definition.
	 * @param screenName
	 * @param screen
	 */
	void registerScreenDefinition(String screenName,Screen screen);
	
	/**
	 * Check if the screen name is present in the registry. 
	 * @param screenName
	 * @return if this registry contains the screen definition for the input screen name.
	 */
	boolean containsScreenDefinition(String screenName);
	
	
	/**
	 * Return the Screen Definition for the screen name.
	 * @param screenName
	 * @return the Screen Definition for the given screen name.
	 */
	Screen getScreenDefinition(String screenName);
}
