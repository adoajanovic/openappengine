/**
 * 
 */
package com.openappengine.facade.ui.common;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @Dec 16, 2011
 */
public class FieldReference implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fieldName;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
