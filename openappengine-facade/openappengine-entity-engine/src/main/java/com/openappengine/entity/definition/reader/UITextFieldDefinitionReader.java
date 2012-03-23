/**
 * 
 */
package com.openappengine.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.entity.definition.ui.UIField;
import com.openappengine.entity.definition.ui.UITextField;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class UITextFieldDefinitionReader implements UIFieldDefinitionReader {

	@Override
	public UIField getUIFieldDefinition(Element fieldElement) {
		UITextField uiTextField = new UITextField();
		Integer length = UtilXml.readIntegerElementAttribute(fieldElement,"length");
		if (length != null) {
			uiTextField.setLength(length);
		}
		return uiTextField;
	}

}
