/**
 * 
 */
package com.openappengine.facade.ui.core;

import org.springframework.util.Assert;

import com.openappengine.facade.ui.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ScreenTransitionHandler implements TransitionHandler {
	
	private ScreenApplicationContext applicationContext;

	@Override
	public void setScreenApplicationContext(ScreenApplicationContext context) {
		Assert.notNull(context, "ScreenApplicationContext cannot be null.");
		this.applicationContext = context;
	}
}
