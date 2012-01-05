/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.FormSingleComponent;

/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public class FormGuiElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final String ATTR_ENTITY_VALUE_REF = "entity-value-ref";
	
	private static final String ATTR_NAME = "name";

	@Override
	public GuiComponent parse(Element element) {
		FormSingleComponent formSingleComponent = new FormSingleComponent();
		String attrName = element.getAttribute(ATTR_NAME);
		if(StringUtils.isEmpty(attrName)) {
			throw new XmlDefinitionParserException("[Element :" + getParsedNodeName() + "] attribute [name] cannot be empty.");
		}
		
		formSingleComponent.setName(attrName);
		
		String attrEntityValueRef = element.getAttribute(ATTR_ENTITY_VALUE_REF);
		formSingleComponent.setEntityValueRef(attrEntityValueRef);
		
		return formSingleComponent;
	}

	@Override
	public String getParsedNodeName() {
		return ParserConstants.FORM_SINGLE_ELEMENT_PARSER;
	}

}
