/**
 * 
 */
package com.openappengine.facade.core.executor.action;

/**
 * @author hrishi
 */
public abstract class Action implements Executable {
	
	private String outgoingTransition;
	
	private String valueField;

	public String getOutgoingTransition() {
		return outgoingTransition;
	}

	public void setOutgoingTransition(String outgoingTransition) {
		this.outgoingTransition = outgoingTransition;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

}
