/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.widget.FormFieldComponent;
import com.openappengine.facade.core.component.widget.FormSingleComponent;

/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public class FormGuiElementDefinitionParser extends AbstractGuiElementDefinitionParser {
	
	private static final String ATTR_ID = "id";

	private static final String ATTR_ENTITY_VALUE_REF = "value-ref";
	
	private static final String ATTR_NAME = "name";

	private static final String ATTR_TRANSITION = "transition";
	
	@Override
	public GuiComponent parse(Element element) {
		FormSingleComponent formSingleComponent = new FormSingleComponent();
		
		String attrId = element.getAttribute(ATTR_ID);
		if(StringUtils.isEmpty(attrId)) {
			throw new XmlDefinitionParserException("[Element :" + getParsedNodeName() + "] attribute [id] cannot be empty.");
		}
		formSingleComponent.setId(attrId);
		
		String attrName = element.getAttribute(ATTR_NAME);
		if(StringUtils.isEmpty(attrName)) {
			throw new XmlDefinitionParserException("[Element :" + getParsedNodeName() + "] attribute [name] cannot be empty.");
		}
		
		String attrTransition = element.getAttribute(ATTR_TRANSITION);
		if(!StringUtils.isEmpty(attrTransition)) {
			formSingleComponent.setTransition(attrTransition);
		}
		
		formSingleComponent.setName(attrName);
		
		String attrEntityValueRef = element.getAttribute(ATTR_ENTITY_VALUE_REF);
		formSingleComponent.setEntityValueRef(attrEntityValueRef);
		
		NodeList childNodes = element.getChildNodes();
		if(childNodes != null) {
			for(int i=0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if(node instanceof Element) {
					GuiElementDefinitionParser parser = getScreenElementDefinitionParser(node.getNodeName());
					GuiComponent component = parser.parse((Element) node);
					if(component instanceof FormFieldComponent) {
						formSingleComponent.addField((FormFieldComponent) component);
					}
				}
			}
		}
		
		return formSingleComponent;
	}

	@Override
	public String getParsedNodeName() {
		return ParserConstants.FORM_SINGLE_ELEMENT_PARSER;
	}

}