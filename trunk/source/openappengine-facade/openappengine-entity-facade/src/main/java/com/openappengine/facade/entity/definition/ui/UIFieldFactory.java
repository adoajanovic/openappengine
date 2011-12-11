/**
 * 
 */
package com.openappengine.facade.entity.definition.ui;

import org.w3c.dom.Element;

import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class UIFieldFactory {
    
    public static UIField getUIField(Element element) {
	String fieldType = UtilXml.readElementAttribute(element, "fieldType");
	if("textField".equals(fieldType)) {
	    return new UITextField(element);
	}
	//TODO - Add other field types
	return null;
    }

}
