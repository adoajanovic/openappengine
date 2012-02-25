package com.openappengine.gui.engine.context.factory.support.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.ui.container.WidgetContainer;
import com.openappengine.gui.engine.core.widget.Widget;

public class WidgetsContainerParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		WidgetContainer widgetsComponent = new WidgetContainer();
		NodeList nl = element.getChildNodes();
		if(nl != null) {
			for(int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if(node instanceof Element) {
					if(!isNodeParseable(node.getNodeName())) {
						GuiElementDefinitionParser delegate = createNodeParserDelegate(node);
						GuiComponent component = delegate.parse((Element) node);
						
						//Add Component if it is a child of WidgetType.
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
