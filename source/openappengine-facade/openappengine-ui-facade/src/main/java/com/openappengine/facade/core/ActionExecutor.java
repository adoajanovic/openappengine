/**
 * 
 */
package com.openappengine.facade.core;

import com.openappengine.facade.core.context.ScreenApplicationContextAware;
import com.openappengine.facade.ui.action.Action;

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
