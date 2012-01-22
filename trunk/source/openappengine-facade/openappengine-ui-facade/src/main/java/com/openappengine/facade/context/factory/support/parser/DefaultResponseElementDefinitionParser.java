package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.facade.core.component.value.ParameterComponent;

public class DefaultResponseElementDefinitionParser extends
		AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		DefaultResponseComponent defaultResponseComponent = new DefaultResponseComponent();
		String saveCurrentScreen = element.getAttribute("save-current-screen");
		boolean bSaveCurrentScreen = false;
		if(!StringUtils.isEmpty(saveCurrentScreen)) {
			bSaveCurrentScreen = Boolean.parseBoolean(saveCurrentScreen);
		}
		
		defaultResponseComponent.setSaveCurrentScreen(bSaveCurrentScreen);
		
		NodeList nl = element.getChildNodes();
		if(nl != null) {
			for(int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if(node instanceof Element) {
					if(node.getNodeName().equals("parameter")) {
						GuiElementDefinitionParser parser = getScreenElementDefinitionParser(node.getNodeName());
						GuiComponent component = parser.parse((Element) node);
						defaultResponseComponent.getParameters().add((ParameterComponent) component);
					}
				}
			}
		}
		
		return defaultResponseComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "default-response";
	}

}
