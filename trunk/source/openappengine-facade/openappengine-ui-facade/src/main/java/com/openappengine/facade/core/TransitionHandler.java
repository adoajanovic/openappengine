/**
 * 
 */
package com.openappengine.facade.core;

import com.openappengine.facade.core.context.GuiApplicationContextAware;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface TransitionHandler extends GuiApplicationContextAware {

	public void onTransition(TransitionEvent transitionEvent);
	
}
