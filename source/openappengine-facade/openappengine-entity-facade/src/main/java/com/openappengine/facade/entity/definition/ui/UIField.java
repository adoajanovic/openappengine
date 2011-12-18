/**
 * 
 */
package com.openappengine.facade.entity.definition.ui;


/**
 * @author hrishikesh.joshi
 *
 */
public class UIField {
	
	/**
	 *  Text Field.
	 */
	public static final String TEXT_FIELD = "text-field";
	
	private String fieldType;
	
	public UIField(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldType() {
	    return fieldType;
	}

	public void setFieldType(String fieldType) {
	    this.fieldType = fieldType;
	}
	
	//TODO - Add more subclasses each corresponding to a Custom UIField.

}
