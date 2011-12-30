/**
 * 
 */
package com.openappengine.facade.core.executor.action;

/**
 * @author hrishi
 */
public abstract class Action implements Executable {
	
	private String outgoingTransition;

	public String getOutgoingTransition() {
		return outgoingTransition;
	}

	public void setOutgoingTransition(String outgoingTransition) {
		this.outgoingTransition = outgoingTransition;
	}

}
