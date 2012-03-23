package com.openappengine.entity.definition.ui;

public class UITextArea extends UIField {
	
	private int length = 50;

	public UITextArea(String fieldType) {
		super(fieldType);
	}

	public UITextArea() {
		super(UIField.TEXT_AREA);	
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
	

}
