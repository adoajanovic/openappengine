package com.openappengine.facade.entity.definition.ui;

import org.w3c.dom.Element;

import com.openappengine.utility.UtilXml;

public class UITextField extends UIField {

    private int length = 10; //TODO DEFAULT
    
    /**
     * @param uiFieldElement
     */
    public UITextField(Element uiFieldElement) {
	super(uiFieldElement);
	Integer length = UtilXml.readIntegerElementAttribute(uiFieldElement, "length");
	if(length != null) {
	    this.length = length.intValue();
	}
    }

    public int getLength() {
	return length;
    }

    public void setLength(int length) {
	this.length = length;
    }
    
    
}