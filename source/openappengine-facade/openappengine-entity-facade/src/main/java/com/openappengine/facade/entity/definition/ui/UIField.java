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
	
	private Element uiFieldElement;
	
	public UIField(Element uiFieldElement) {
	    String uiFieldType = UtilXml.readElementAttribute(uiFieldElement, "fieldType");
	    this.uiFieldElement = uiFieldElement;
	}
	
	//TODO - Add more subclasses each corresponding to a Custom UIField.

}
