/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.EntityFindOneActionComponent;
import com.openappengine.facade.core.component.value.FieldMapComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class EntityFindOneActionElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final String ATTR_AUTO_FIELD_MAP = "auto-field-map";

	private static final String ATTR_VALUE_FIELD = "value-field";

	private static final String ATTR_ENTITY_NAME = "entity-name";
	
	private static final String ATTR_CONDITION = "condition";

	@Override
	public GuiComponent parse(Element element) {
		EntityFindOneActionComponent entityFindOneActionComponent = new EntityFindOneActionComponent();
		String entityName = element.getAttribute(ATTR_ENTITY_NAME);
		if(StringUtils.isEmpty(entityName)) {
			throw new XmlDefinitionParserException("Attribute entity-name cannot be empty.");
		}
		entityFindOneActionComponent.setEntityName(entityName);
		
		String valueField = element.getAttribute(ATTR_VALUE_FIELD);
		if(StringUtils.isEmpty(valueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-find-one.");
		}
		entityFindOneActionComponent.setValueField(valueField);
		
		if(StringUtils.isEmpty(valueField)) {
			throw new XmlDefinitionParserException("Attribute value-field is mandatory for entity-find-one.");
		}
		entityFindOneActionComponent.setValueField(valueField);
		
		if(!StringUtils.isEmpty(element.getAttribute(ATTR_CONDITION))) {
			entityFindOneActionComponent.setConditionExpression(element.getAttribute(ATTR_CONDITION));
		}
		
		String autoFieldMap = element.getAttribute(ATTR_AUTO_FIELD_MAP);
		Boolean bAutoFieldMap = false;
		if(!StringUtils.isEmpty(autoFieldMap)) {
			bAutoFieldMap = BooleanUtils.toBooleanObject(autoFieldMap);
			if(bAutoFieldMap == null) {
				bAutoFieldMap = false;
			}
		}
		entityFindOneActionComponent.setAutoFieldMap(bAutoFieldMap);
		
		NodeList fieldMapNodes = element.getElementsByTagName(ParserConstants.FIELD_MAP_PARSER);
		if(BooleanUtils.isFalse(bAutoFieldMap)) {
			if(fieldMapNodes == null || fieldMapNodes.getLength() == 0) {
				throw new XmlDefinitionParserException("<value-field> should be provided if attribute auto-field-map is set as false for entity-find-one.");
			}
			
			for(int i = 0 ; i < fieldMapNodes.getLength(); i++) {
				Node node = fieldMapNodes.item(i);
				if(node instanceof Element) {
					Element fieldMapEle = (Element) node;
					GuiElementDefinitionParser parser = getDelegate().getScreenElementDefinitionParser(ParserConstants.FIELD_MAP_PARSER);
					FieldMapComponent fieldMap = (FieldMapComponent) parser.parse(fieldMapEle);
					entityFindOneActionComponent.addFieldMap(fieldMap);
				}
			}
		}
		
		return entityFindOneActionComponent;
	}

	@Override
	protected boolean isNodeParseable(String nodeName) {
		return StringUtils.equals(ParserConstants.ENTITY_FIND_ONE_PARSER, nodeName);
	}

}
