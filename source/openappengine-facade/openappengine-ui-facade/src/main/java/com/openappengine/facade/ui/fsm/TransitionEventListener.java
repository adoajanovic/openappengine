/**
 * 
 */
package com.openappengine.facade.ui.fsm;

import org.springframework.context.ApplicationListener;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public abstract class TransitionEventListener implements ApplicationListener<TransitionEvent> {
	
	public abstract void onApplicationEvent(TransitionEvent event);
}
