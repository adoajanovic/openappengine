/**
 * 
 */
package com.openappengine.facade.core.widget;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class FormFieldComponent extends AbstractGuiComponent implements ValueRefAware<Object> {

	private static final long serialVersionUID = 1L;
	
	private String entryName;
	
	private boolean hidden; 
	
	private String valueRef;
	
	private Object value;
	
	@Override
	public String getComponentType() {
		return "form-field";
	}

	@Override
	public String getComponentName() {
		return "form-field";
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getValueRef() {
		return valueRef;
	}

	public void setValueRef(String valueRef) {
		this.valueRef = valueRef;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

}
