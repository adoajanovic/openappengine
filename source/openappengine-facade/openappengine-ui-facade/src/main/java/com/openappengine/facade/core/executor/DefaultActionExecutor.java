/**
 * 
 */
package com.openappengine.facade.core.executor;

import org.springframework.util.Assert;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.executor.action.ActionHandler;

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
	public void execute(ActionHandler action) {
		Assert.notNull(action,"ActionHandler cannot be null.");
		action.execute();
	}

}
