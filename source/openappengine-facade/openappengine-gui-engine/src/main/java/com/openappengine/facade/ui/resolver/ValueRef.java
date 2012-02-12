/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public class ValueRef<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *  Variable Name to Resolve the Actual Value.
	 */
	private String contextVariableName;
	
	
	public ValueRef(String contextVariableName) {
		super();
		this.contextVariableName = contextVariableName;
	}
	
	public T getActualValue() {
		return null;
	}

	public String getContextVariableName() {
		return contextVariableName;
	}

	public void setContextVariableName(String contextVariableName) {
		this.contextVariableName = contextVariableName;
	}
	
	
}
