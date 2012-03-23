package com.openappengine.gui.engine.context.factory.support.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.transition.TransitionActions;

public class TransitionActionsElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		TransitionActions transitionActions = new TransitionActions();
		if(element != null) {
			NodeList nl = element.getChildNodes();
			for(int i=0; i < nl.getLength();i++) {
				Node childNode = nl.item(i);
				if(childNode instanceof Element) {
					if(!isNodeParseable(childNode.getNodeName())) {
						GuiElementDefinitionParser parser = createNodeParserDelegate(childNode);
						AbstractExecutableComponent component = (AbstractExecutableComponent) parser.parse((Element) childNode);
						transitionActions.addExecutable(component);
					}
				}
			}
		}
		return transitionActions;
	}

	@Override
	public String getParsedNodeName() {
		return "transition-actions";
	}

}
