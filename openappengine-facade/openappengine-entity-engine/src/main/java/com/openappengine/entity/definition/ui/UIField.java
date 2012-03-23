/**
 * 
 */
package com.openappengine.entity.definition.ui;


/**
 * @author hrishikesh.joshi
 *
 */
public class UIField {
	
	/**
	 *  Text Field.
	 */
	public static final String TEXT_FIELD = "text-field";
	
	/**
	 *  Text Area.
	 */
	public static final String TEXT_AREA = "text-area";
	
	/**
	 *  Hidden Field.
	 */
	public static final String HIDDEN_FIELD = "hidden-field";
	
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
