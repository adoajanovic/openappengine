/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.component.executable.PreRenderActionsComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class PreActionsElementParser extends AbstractGuiElementDefinitionParser {

	@Override
	public PreRenderActionsComponent parse(Element element) {
		PreRenderActionsComponent preRenderActionsComponent = new PreRenderActionsComponent();
		if(element != null) {
			NodeList nl = element.getChildNodes();
			for(int i=0; i < nl.getLength();i++) {
				Node childNode = nl.item(i);
				if(childNode instanceof Element) {
					if(!isNodeParseable(childNode.getNodeName())) {
						GuiElementDefinitionParser parser = createNodeParserDelegate(childNode);
						AbstractExecutableComponent component = (AbstractExecutableComponent) parser.parse((Element) childNode);
						preRenderActionsComponent.addChildComponent(component);
					}
				}
			}
		}
		return preRenderActionsComponent;
	}

	@Override
	protected boolean isNodeParseable(String nodeName) {
		return StringUtils.equals(nodeName,ELEMENT_PRE_ACTIONS);
	}

}
