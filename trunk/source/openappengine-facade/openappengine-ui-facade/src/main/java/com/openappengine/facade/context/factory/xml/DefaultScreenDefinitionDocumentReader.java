/**
 * 
 */
package com.openappengine.facade.context.factory.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.context.factory.support.ScreenDefinitionParserDelegate;
import com.openappengine.facade.context.factory.support.parser.ScreenElementDefinitionParser;
import com.openappengine.facade.core.component.executable.PreActionsComponent;
import com.openappengine.facade.core.component.ui.UIRootComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class DefaultScreenDefinitionDocumentReader implements ScreenDefinitionDocumentReader {
	
	private static final String ELEMENT_PRE_ACTIONS = "pre-actions";

	private UIRootComponent uiRootComponent;

	public DefaultScreenDefinitionDocumentReader() {
		setUiRootComponent(new UIRootComponent());
	}

	@Override
	public void registerScreenDefinition(Document doc) {
		Element root = doc.getDocumentElement();
		
		ScreenDefinitionParserDelegate delegate = createParserDelegate(root);
		
		parseScreenDefinition(root, delegate);
	}

	protected ScreenDefinitionParserDelegate createParserDelegate(Element root) {
		ScreenDefinitionParserDelegate parserDelegate = new ScreenDefinitionParserDelegate(root);
		return parserDelegate;
	}
	
	protected void parseScreenDefinition(Element root,ScreenDefinitionParserDelegate delegate) {
		NodeList nodeList = root.getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				parseElement((Element)node, delegate);
			}
		}
	}
	
	private void parseElement(Element element,ScreenDefinitionParserDelegate delegate) {
		if(delegate.nodeNameEquals(element, ELEMENT_PRE_ACTIONS)) {
			PreActionsComponent parsePreActions = parsePreActions(element, delegate);
			uiRootComponent.setPreActionsComponent(parsePreActions);
		}
	}
	
	/**
	 * Parse the PreActions Node and return the PreActions Component that can be
	 * set in the Component Tree.
	 * @param element
	 * @param delegate
	 * @return PreActionsComponent created from the parsed XML Node.
	 */
	private PreActionsComponent parsePreActions(Element element,ScreenDefinitionParserDelegate delegate) {
		ScreenElementDefinitionParser parser = delegate.getScreenElementDefinitionParser(ELEMENT_PRE_ACTIONS);
		PreActionsComponent preActions = (PreActionsComponent) parser.parse(element);
		return preActions;
	}

	/**
	 * @return the uiRootComponent
	 */
	public UIRootComponent getUiRootComponent() {
		return uiRootComponent;
	}

	/**
	 * @param uiRootComponent the uiRootComponent to set
	 */
	public void setUiRootComponent(UIRootComponent uiRootComponent) {
		this.uiRootComponent = uiRootComponent;
	}

}
