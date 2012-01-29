/**
 * 
 */
package com.openappengine.facade.fsm;

import org.springframework.context.ApplicationEvent;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class TransitionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private String eventName;
	
	private ExternalContext externalContext;
	
	private ELContext elContext;
	
	public TransitionEvent(String eventName,ExternalContext externalContext,ELContext elContext) {
		super(eventName);
		this.eventName = eventName;
		this.setExternalContext(externalContext);
		this.setElContext(elContext);
	}

	public String getEventName() {
		return eventName;
	}

	protected void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public ExternalContext getExternalContext() {
		return externalContext;
	}

	protected void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	public ELContext getElContext() {
		return elContext;
	}

	protected void setElContext(ELContext elContext) {
		this.elContext = elContext;
	}
}
