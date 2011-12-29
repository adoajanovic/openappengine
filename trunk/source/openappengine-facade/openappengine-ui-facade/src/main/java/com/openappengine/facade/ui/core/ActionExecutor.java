/**
 * 
 */
package com.openappengine.facade.ui.core;

import com.openappengine.facade.ui.action.Action;
import com.openappengine.facade.ui.core.context.ScreenApplicationContextAware;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ActionExecutor extends ScreenApplicationContextAware {
	
	/**
	 * Execute the Action.
	 * @param action
	 */
	void execute(Action action);
	
}
