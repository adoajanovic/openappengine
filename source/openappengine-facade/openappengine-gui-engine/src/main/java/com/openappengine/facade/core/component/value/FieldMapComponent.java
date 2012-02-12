/**
 * 
 */
package com.openappengine.facade.core.component.value;

import com.openappengine.facade.ui.resolver.ValueRef;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class FieldMapComponent extends AbstractValueHolderComponent {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	
	private String  valueRefField;
	
	private ValueRef<Object> valueRef;
	
	@Override
	public String getComponentName() {
		return "field-map";
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the valueRef
	 */
	public ValueRef<Object> getValueRef() {
		return valueRef;
	}

	/**
	 * @param valueRef the valueRef to set
	 */
	public void setValueRef(ValueRef<Object> valueRef) {
		this.valueRef = valueRef;
	}

	/**
	 * @return the valueRefField
	 */
	public String getValueRefField() {
		return valueRefField;
	}

	/**
	 * @param valueRefField the valueRefField to set
	 */
	public void setValueRefField(String valueRefField) {
		this.valueRefField = valueRefField;
		this.setValueRef(new ValueRef<Object>(valueRefField));
	}

}
