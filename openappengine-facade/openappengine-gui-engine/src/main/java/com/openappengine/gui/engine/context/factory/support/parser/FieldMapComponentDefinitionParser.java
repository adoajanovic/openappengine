/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.value.FieldMapComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class FieldMapComponentDefinitionParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		FieldMapComponent fieldMapComponent = new FieldMapComponent();
		String fieldName = element.getAttribute("field-name");
		String valueRef = element.getAttribute("value-ref");
		if(StringUtils.isEmpty(fieldName)) {
			throw new XmlDefinitionParserException("Attribute field-name cannot be empty.");
		}
		
		if(StringUtils.isEmpty(valueRef)) {
			throw new XmlDefinitionParserException("Attribute value-ref cannot be empty.");
		}
		
		fieldMapComponent.setFieldName(fieldName);
		fieldMapComponent.setValueRefField(valueRef);
		return fieldMapComponent;
	}

	@Override
	public String getParsedNodeName() {
		return ParserConstants.FIELD_MAP_PARSER;
	}

}
