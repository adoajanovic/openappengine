/**
 * 
 */
package com.openappengine.entity.definition.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;
import org.w3c.dom.Element;

import com.openappengine.entity.definition.ui.UIField;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * 
 */
public class FieldTypeDefinitionReader {
	
	private Map<String, UIFieldDefinitionReader> uiDefinitionReaders = new HashMap<String, UIFieldDefinitionReader>();
	
	public UIField getUIField(Element element) {
		String fieldType = UtilXml.readElementAttribute(element, "type");
		UIFieldDefinitionReader uiDefinitionReader = uiDefinitionReaders.get(fieldType);
		Assert.notNull(uiDefinitionReader,"No UIFieldDefinitonReader found for field-type:" + fieldType);
		UIField uiField = uiDefinitionReader.getUIFieldDefinition(element);
		return uiField;
	}

	protected Map<String, UIFieldDefinitionReader> getUiDefinitionReaders() {
		return uiDefinitionReaders;
	}

	public void setUiDefinitionReaders(Map<String, UIFieldDefinitionReader> uiDefinitionReaders) {
		this.uiDefinitionReaders = uiDefinitionReaders;
	}

}
