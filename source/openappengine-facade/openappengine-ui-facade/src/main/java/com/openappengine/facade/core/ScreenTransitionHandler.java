/**
 * 
 */
package com.openappengine.facade.core;

import org.springframework.util.Assert;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ScreenTransitionHandler implements TransitionHandler {
	
	private GuiApplicationContext applicationContext;

	@Override
	public void setGuiApplicationContext(GuiApplicationContext context) {
		Assert.notNull(context, "ScreenApplicationContext cannot be null.");
		this.applicationContext = context;
	}
}
