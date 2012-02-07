/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.executor.annotations.Mode;

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
	
	
	boolean supportsMode(ActionHandler actionHandler, Mode mode);
	
	/**
	 * Register the Action Handlers.
	 * @param name
	 * @param actionHandler
	 */
	void registerActionHandler(String name,Class<? extends ActionHandler> actionHandlerClass);
	
}
