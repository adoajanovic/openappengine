/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.EntityDeleteActionComponent;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
public class EntityDeleteElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final String ATTR_VALUE_FIELD = "value-field";

	@Override
	public GuiComponent parse(Element element) {
		EntityDeleteActionComponent entityDeleteActionComponent = new EntityDeleteActionComponent();
		String valueField = element.getAttribute(ATTR_VALUE_FIELD);
		if(StringUtils.isEmpty(valueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-delete.");
		}
		entityDeleteActionComponent.setValueField(valueField);
		
		String attrSuccessMessage = element.getAttribute("success-message");
		if(!StringUtils.isEmpty(attrSuccessMessage)) {
			entityDeleteActionComponent.setSuccessMessage(attrSuccessMessage);
		}
		
		return entityDeleteActionComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "entity-delete";
	}

}
