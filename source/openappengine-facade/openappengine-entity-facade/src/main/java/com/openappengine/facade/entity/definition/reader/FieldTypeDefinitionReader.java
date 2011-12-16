/**
 * 
 */
package com.openappengine.facade.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.facade.entity.definition.ui.UIField;
import com.openappengine.facade.entity.definition.ui.UITextField;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * 
 */
public class FieldTypeDefinitionReader {
	
	public UIField getUIField(Element element) {
		String fieldType = UtilXml.readElementAttribute(element, "type");
		if ("text-field".equals(fieldType)) {
			return new UITextField(element);
		}
		// TODO - Add other field types
		return null;
	}

}
