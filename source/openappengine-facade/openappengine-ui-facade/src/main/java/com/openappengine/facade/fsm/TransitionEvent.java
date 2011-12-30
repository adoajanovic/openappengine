/**
 * 
 */
package com.openappengine.facade.fsm;

import org.springframework.context.ApplicationEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class TransitionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private String eventName;
	
	public TransitionEvent(String eventName) {
		super(eventName);
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
