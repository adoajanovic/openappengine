/**
 * 
 */
package com.openappengine.gui.engine.core.executor;

import org.springframework.util.Assert;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
@Deprecated
public class DefaultActionExecutor implements ActionExecutor {
	
	private GuiEngineContext context;

	@Override
	public void setGuiApplicationContext(GuiEngineContext context) {
		this.context = context;
	}

	@Override
	public void execute(ActionHandler action) {
		Assert.notNull(action,"ActionHandler cannot be null.");
		action.execute(null);
	}

}
