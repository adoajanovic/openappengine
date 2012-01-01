/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.PreActionsComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class PreActionsElementParser extends AbstractScreenElementDefinitionParser {

	@Override
	public PreActionsComponent parse(Element element) {
		PreActionsComponent preActionsComponent = new PreActionsComponent();
		if(element != null) {
			NodeList nl = element.getChildNodes();
			for(int i=0; i < nl.getLength();i++) {
				Node childNode = nl.item(i);
				if(childNode instanceof Element) {
					if(!isNodeParseable(childNode.getNodeName())) {
						ScreenElementDefinitionParser parser = createNodeParserDelegate(childNode);
						GuiComponent component = parser.parse((Element) childNode);
						preActionsComponent.addChildComponent(component);
					}
				}
			}
		}
		return preActionsComponent;
	}

	@Override
	protected boolean isNodeParseable(String nodeName) {
		return StringUtils.equals(nodeName,ELEMENT_PRE_ACTIONS);
	}

}
