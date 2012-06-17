package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.EntitySaveActionComponent;

public class EntitySaveActionElementDefinitionParser extends AbstractGuiElementDefinitionParser {
	
	private static final String ATTR_UPDATE_IF_EXISTS = "updateIfExists";
	
	private static final String ATTR_VALUE_FIELD = "value-field";
	
	private static final String ATTR_SUCCESS_MESSAGE = "success-message";
	
	@Override
	public GuiComponent parse(Element element) {
		EntitySaveActionComponent entitySaveActionComponent = new EntitySaveActionComponent();
		String attrValueField = element.getAttribute(ATTR_VALUE_FIELD);
		if(StringUtils.isEmpty(attrValueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-save.");
		}
		entitySaveActionComponent.setValueField(attrValueField);
		
		String attrUpdateIfExists = element.getAttribute(ATTR_UPDATE_IF_EXISTS);
		if(!StringUtils.isEmpty(attrUpdateIfExists)) {
			boolean updateIfExists = Boolean.parseBoolean(attrUpdateIfExists);
			entitySaveActionComponent.setUpdateIfExists(updateIfExists);
		}
		
		String attrSuccessMessage = element.getAttribute(ATTR_SUCCESS_MESSAGE);
		if(!StringUtils.isEmpty(attrSuccessMessage)) {
			entitySaveActionComponent.setSuccessMessage(attrSuccessMessage);
		}
		
		return entitySaveActionComponent;
	}

	@Override
	public String getParsedNodeName() {
		return ParserConstants.ENTITY_SAVE;
	}

}
