package com.openappengine.facade.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.facade.entity.definition.ui.UIField;
import com.openappengine.facade.entity.definition.ui.UITextArea;
import com.openappengine.utility.UtilXml;

public class UITextAreaDefinitionReader extends UITextFieldDefinitionReader {
	
	public UIField getUIFieldDefinition(Element fieldElement) {
		UITextArea uiTextArea = new UITextArea();
		Integer length = UtilXml.readIntegerElementAttribute(fieldElement,"length");
		if (length != null) {
			uiTextArea.setLength(length);
		}
		return uiTextArea;
	}

	
}
