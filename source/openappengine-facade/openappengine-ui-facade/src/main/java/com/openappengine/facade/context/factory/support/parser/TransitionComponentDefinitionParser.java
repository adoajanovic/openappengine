/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.condition.ConditionComponent;
import com.openappengine.facade.core.component.transition.TransitionActions;
import com.openappengine.facade.core.component.transition.TransitionComponent;
import com.openappengine.facade.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.facade.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.facade.core.component.transition.response.ErrorResponseComponent;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public class TransitionComponentDefinitionParser extends AbstractGuiElementDefinitionParser {
	
	private static final String ATTR_ID = "id";
	
	@Override
	public GuiComponent parse(Element element) {
		TransitionComponent transition = new TransitionComponent();
		String attrId = element.getAttribute(ATTR_ID);
		if(StringUtils.isEmpty(attrId)) {
			throw new XmlDefinitionParserException("Attribute id cannot be null for <transition>.");
		}
		transition.setId(attrId);
		NodeList childNodes = element.getChildNodes();
		if(childNodes != null) {
			for(int i=0;i < childNodes.getLength();i++) {
				Node childNode = childNodes.item(i);
				if(childNode instanceof Element) {
					Element child = (Element) childNode;
					GuiElementDefinitionParser parser = getScreenElementDefinitionParser(child.getNodeName());
					GuiComponent component = parser.parse(child);
					if(child.getNodeName().equals("condition")) {
						transition.setCondition((ConditionComponent) component);
					} else if(child.getNodeName().equals("transition-actions")) {
						transition.setTransitionActions((TransitionActions) component);
					} else if(child.getNodeName().equals("conditional-response")) {
						transition.getConditionalResponses().add((ConditionalResponseComponent) component);
					} else if(child.getNodeName().equals("default-response")) {
						transition.setDefaultResponseComponent((DefaultResponseComponent) component);
					} else if(child.getNodeName().equals("error-response")) {
						transition.setErrorResponseComponent((ErrorResponseComponent) component);
					}
				}
			}
		}
		return transition;
	}

	@Override
	public String getParsedNodeName() {
		return "transition";
	}

}
