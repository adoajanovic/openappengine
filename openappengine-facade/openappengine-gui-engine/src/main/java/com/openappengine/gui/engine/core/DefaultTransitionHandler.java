/**
 * 
 */
package com.openappengine.gui.engine.core;

import org.springframework.util.Assert;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class DefaultTransitionHandler implements TransitionHandler {
	
	private GuiEngineContext applicationContext;
	
	@Override
	public void setGuiApplicationContext(GuiEngineContext context) {
		Assert.notNull(context, "ScreenApplicationContext cannot be null.");
		this.applicationContext = context;
	}

	@Override
	public void onTransition(TransitionEvent transitionEvent) {
		
	}
}
