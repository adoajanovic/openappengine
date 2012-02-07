/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.executor.annotations.EntityMode;

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
	
	
	ActionHandler getActionHandler(String actionName,EntityMode mode);
	
	void registerActionHandler(String actionName,EntityMode entityMode,ActionHandler actionHandler);

	/**
	 * Register the Action Handlers.
	 * @param name
	 * @param actionHandler
	 */
	void registerActionHandler(String name,ActionHandler actionHandler);
	
}
