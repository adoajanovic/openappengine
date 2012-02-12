/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

import com.openappengine.gui.engine.core.executor.annotations.Mode;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public interface ActionHandlerFactory {
	
	/**
	 * Get ActionHandler mapped to the input name.
	 * @param name
	 * @return
	 */
	ActionHandler getActionHandler(String name);
	
	
	/**
	 * Register the Action Handlers.
	 * @param name
	 * @param actionHandler
	 */
	void registerActionHandler(String name,Class<? extends ActionHandler> actionHandlerClass);
	
}
