package com.openappengine.facade.core.value;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.ValueHolder;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultValueHolder implements ValueHolder {

	private static final long serialVersionUID = 1L;
	
	private Object value;
	
	private String valueReference;
	
	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public boolean hasValueReference() {
		return !StringUtils.isEmpty(getValueReference());
	}

	@Override
	public String getValueReference() {
		return valueReference;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setValueReference(String valueReference) {
		this.valueReference = valueReference;
	}
}
