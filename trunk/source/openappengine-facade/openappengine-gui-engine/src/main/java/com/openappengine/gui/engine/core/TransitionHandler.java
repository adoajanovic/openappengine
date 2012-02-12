/**
 * 
 */
package com.openappengine.gui.engine.core;

import com.openappengine.gui.engine.core.context.GuiApplicationContextAware;
import com.openappengine.gui.engine.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface TransitionHandler extends GuiApplicationContextAware {

	public void onTransition(TransitionEvent transitionEvent);
	
}
