package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.condition.ConditionComponent;
import com.openappengine.gui.engine.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.gui.engine.core.component.value.ParameterComponent;

public class ConditionalResponseElementDefinitionParser extends
		AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		ConditionalResponseComponent conditionalResponseComponent = new ConditionalResponseComponent();
		String saveCurrentScreen = element.getAttribute("save-current-screen");
		boolean bSaveCurrentScreen = false;
		if(!StringUtils.isEmpty(saveCurrentScreen)) {
			bSaveCurrentScreen = Boolean.parseBoolean(saveCurrentScreen);
		}
		
		conditionalResponseComponent.setSaveCurrentScreen(bSaveCurrentScreen);
		
		NodeList nl = element.getChildNodes();
		if(nl != null) {
			for(int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if(node instanceof Element) {
					GuiElementDefinitionParser parser = getScreenElementDefinitionParser(node.getNodeName());
					GuiComponent component = parser.parse((Element) node);
					if(node.getNodeName().equals("parameter")) {
						conditionalResponseComponent.getParameters().add((ParameterComponent) component);
					} else if(node.getNodeName().equals("condition")) {
						conditionalResponseComponent.setCondition((ConditionComponent) component);
					}
				}
			}
		}
		
		return conditionalResponseComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "conditional-response";
	}

}
