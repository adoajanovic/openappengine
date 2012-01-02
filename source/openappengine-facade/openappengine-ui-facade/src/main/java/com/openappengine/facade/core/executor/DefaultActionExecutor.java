/**
 * 
 */
package com.openappengine.facade.core.executor;

import org.springframework.util.Assert;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.executor.action.Action;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class DefaultActionExecutor implements ActionExecutor {
	
	private GuiApplicationContext context;

	@Override
	public void setGuiApplicationContext(GuiApplicationContext context) {
		this.context = context;
	}

	@Override
	public void execute(Action action) {
		Assert.notNull(action,"Action cannot be null.");
		action.execute(context);
	}

}
