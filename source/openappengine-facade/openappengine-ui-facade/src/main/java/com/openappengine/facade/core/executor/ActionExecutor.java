/**
 * 
 */
package com.openappengine.facade.core.executor;

import com.openappengine.facade.core.context.GuiApplicationContextAware;
import com.openappengine.facade.core.executor.action.Action;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ActionExecutor extends GuiApplicationContextAware {
	
	/**
	 * Execute the Action.
	 * @param action
	 */
	void execute(Action action);
	
}
