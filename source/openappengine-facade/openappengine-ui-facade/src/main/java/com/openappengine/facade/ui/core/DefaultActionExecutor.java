/**
 * 
 */
package com.openappengine.facade.ui.core;

import org.springframework.util.Assert;

import com.openappengine.facade.ui.action.Action;
import com.openappengine.facade.ui.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class DefaultActionExecutor implements ActionExecutor {
	
	private ScreenApplicationContext context;

	@Override
	public void setScreenApplicationContext(ScreenApplicationContext context) {
		this.context = context;
	}

	@Override
	public void execute(Action action) {
		Assert.notNull(action,"Action cannot be null.");
		//action.execute(screenContext);
	}

}
