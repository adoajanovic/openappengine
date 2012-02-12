package com.openappengine.facade.context.factory.support.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.context.factory.xml.NodeNames;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.container.PageContentComponent;

public class PageContentElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		PageContentComponent pageContentComponent = new PageContentComponent();
		NodeList nl = element.getChildNodes();
		for(int i = 0;i<nl.getLength(); i++) {
			Node node = nl.item(i);
			//parse widgets.
			if(node instanceof Element) {
				GuiElementDefinitionParser parser = getScreenElementDefinitionParser(node.getNodeName());
				GuiComponent component = parser.parse((Element) node);
				pageContentComponent.addChildComponent(component);
			}
		}
		return pageContentComponent;
	}

	@Override
	public String getParsedNodeName() {
		return NodeNames.PAGE_CONTENT;
	}

}
