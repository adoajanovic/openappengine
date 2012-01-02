/**
 * 
 */
package com.openappengine.facade.core.executor.action;

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
	void registerActionHandler(String name,ActionHandler actionHandler);
	
}
