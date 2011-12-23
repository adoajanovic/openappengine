/**
 * 
 */
package com.openappengine.facade.ui.widgets.forms;

import java.io.Serializable;

import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class FormValueHolder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Object value = null;
	
	private boolean initilized = false;
	
	private ValueResolver valueResolver;
	
	private Form parentForm;

	/**
	 * @param form
	 */
	public FormValueHolder(Form form) {
		this.parentForm = form;
	}

	public Object getValue() {
		if(!initilized) {
			if(parentForm.getEntityReference() != null) {
				valueResolver = new EntityValueResolver(parentForm.getEntityReference().getEntityName(),parentForm.getFormParams().getParameterMap());
			} 
			//TODO - Add Service Reference in else part or use a factory.
			value = valueResolver.getValue();
		}
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ValueResolver getValueResolver() {
		return valueResolver;
	}

	public void setValueResolver(ValueResolver valueResolver) {
		this.valueResolver = valueResolver;
	}

}
