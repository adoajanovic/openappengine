package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.value.ParameterComponent;

public class ParameterComponentDefinitionParser extends
		AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		ParameterComponent parameterComponent = new ParameterComponent();
		String attrName = element.getAttribute("name");
		if(StringUtils.isEmpty(attrName)) {
			throw new XmlDefinitionParserException("Attribute name cannot be empty for <parameter>");
		}
		parameterComponent.setName(attrName);
		
		String attrValueRef = element.getAttribute("value-ref");
		if(StringUtils.isEmpty(attrValueRef)) {
			throw new XmlDefinitionParserException("Attribute name cannot be empty for <parameter>");
		}
		parameterComponent.setValueRef(attrValueRef);
		
		return parameterComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "parameter";
	}

}
