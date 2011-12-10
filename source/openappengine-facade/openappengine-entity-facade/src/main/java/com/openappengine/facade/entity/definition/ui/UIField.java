/**
 * 
 */
package com.openappengine.facade.entity.definition.ui;

import org.w3c.dom.Element;

import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 *
 */
public class UIField {
	
	private String fieldType;
	
	public UIField(Element uiFieldElement) {
	    this.setFieldType(UtilXml.readElementAttribute(uiFieldElement, "fieldType"));
	}

	public String getFieldType() {
	    return fieldType;
	}

	public void setFieldType(String fieldType) {
	    this.fieldType = fieldType;
	}
	
	//TODO - Add more subclasses each corresponding to a Custom UIField.

}
