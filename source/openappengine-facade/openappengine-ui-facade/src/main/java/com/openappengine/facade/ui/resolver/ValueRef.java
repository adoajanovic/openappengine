/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

import com.openappengine.facade.ui.context.ScreenContext;

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
		ScreenContext screenContext = ScreenContext.getCurrentInstance();
		Validate.notNull(screenContext,"No Active ScreenContext instance found.");
		Object actualValue = screenContext.getVariable(getContextVariableName());
		return (T) actualValue;
	}

	public String getContextVariableName() {
		return contextVariableName;
	}

	public void setContextVariableName(String contextVariableName) {
		this.contextVariableName = contextVariableName;
	}
	
	
}
