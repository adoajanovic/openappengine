package com.openappengine.entity.definition.ui;


public class UITextField extends UIField {

	// TODO - Read default values from a properties file/xml. 
	private int length = 50; 

	/**
	 * @param uiFieldElement
	 */
	public UITextField() {
		super(TEXT_FIELD);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}