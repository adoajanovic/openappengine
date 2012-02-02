package com.openappengine.facade.context.factory.support.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.container.WidgetsComponent;
import com.openappengine.facade.core.component.widget.Widget;

public class WidgetsElementParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		WidgetsComponent widgetsComponent = new WidgetsComponent();
		NodeList nl = element.getChildNodes();
		if(nl != null) {
			for(int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if(node instanceof Element) {
					if(!isNodeParseable(node.getNodeName())) {
						GuiElementDefinitionParser delegate = createNodeParserDelegate(node);
						GuiComponent component = delegate.parse((Element) node);
						
						//Add Component if it is a child of Widget.
						if(component instanceof Widget) {
							widgetsComponent.addChildComponent(component);
						}
					}
				}
			}
		}
		return widgetsComponent;
	}

	@Override
	public String getParsedNodeName() {
		return ParserConstants.WIDGETS;
	}

}
