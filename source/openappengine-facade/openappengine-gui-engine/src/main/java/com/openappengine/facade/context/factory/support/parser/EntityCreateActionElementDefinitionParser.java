/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.EntityCreateTag;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class EntityCreateActionElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final String ATTR_VALUE_FIELD = "value-field";

	private static final String ATTR_ENTITY_NAME = "entity-name";
	
	@Override
	public GuiComponent parse(Element element) {
		EntityCreateTag entityCreateActionComponent = new EntityCreateTag();
		String entityName = element.getAttribute(ATTR_ENTITY_NAME);
		if(StringUtils.isEmpty(entityName)) {
			throw new XmlDefinitionParserException("Attribute entity-name cannot be empty.");
		}
		entityCreateActionComponent.setEntityName(entityName);
		
		String valueField = element.getAttribute(ATTR_VALUE_FIELD);
		if(StringUtils.isEmpty(valueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-find-one.");
		}
		entityCreateActionComponent.setValueField(valueField);
		
		if(StringUtils.isEmpty(valueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-find-one.");
		}
		entityCreateActionComponent.setValueField(valueField);
		
		return entityCreateActionComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "entity-create";
	}

}
