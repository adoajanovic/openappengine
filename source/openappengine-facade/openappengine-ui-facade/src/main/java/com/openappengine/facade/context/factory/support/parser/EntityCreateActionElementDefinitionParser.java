/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.EntityCreateActionComponent;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class EntityCreateActionElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final String ATTR_VALUE_FIELD = "value-field";

	private static final String ATTR_ENTITY_NAME = "entity-name";
	
	private static final String ATTR_ENTITY_MODE = "entity-mode";
	
	@Override
	public GuiComponent parse(Element element) {
		EntityCreateActionComponent entityCreateActionComponent = new EntityCreateActionComponent();
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
		
		String attrEntityMode = element.getAttribute(ATTR_ENTITY_MODE);
		if(StringUtils.isNotEmpty(attrEntityMode)) {
			entityCreateActionComponent.setEntityMode(attrEntityMode);
		}
		
		return entityCreateActionComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "entity-create";
	}

}
