/**
 * 
 */
package com.openappengine.gui.engine.context.factory.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.gui.engine.context.factory.support.ScreenDefinitionParserDelegate;
import com.openappengine.gui.engine.context.factory.support.parser.GuiElementDefinitionParser;
import com.openappengine.gui.engine.context.factory.support.parser.ParserConstants;
import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.component.transition.TransitionComponent;
import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.component.ui.container.PageContentComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class DefaultScreenDefinitionDocumentReader implements ScreenDefinitionDocumentReader {
	
	private GuiRootComponent uiRoot;

	public DefaultScreenDefinitionDocumentReader() {
		//Initialize the root component.
		setUiRoot(new GuiRootComponent());
	}

	@Override
	public GuiRootComponent readUIRootDefinition(Document doc) {
		Element root = doc.getDocumentElement();
		
		ScreenDefinitionParserDelegate delegate = createParserDelegate(root);
		
		parseScreenDefinition(root, delegate);
		
		return getUiRoot();
	}

	protected ScreenDefinitionParserDelegate createParserDelegate(Element root) {
		ScreenDefinitionParserDelegate parserDelegate = new ScreenDefinitionParserDelegate();
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
		//Parse the pre-actions component.
		if(delegate.nodeNameEquals(element, NodeNames.PRE_ACTIONS)) {
			PreRenderActions parsePreActions = parsePreActions(element, delegate);
			getUiRoot().setPreRenderActionComponent(parsePreActions);
		} else if(delegate.nodeNameEquals(element, NodeNames.TRANSITION)) {
			GuiElementDefinitionParser parser = delegate.getScreenElementDefinitionParser(NodeNames.TRANSITION);
			GuiComponent component = parser.parse(element);
			getUiRoot().addScreenTransition((TransitionComponent) component);
		} else if(delegate.nodeNameEquals(element, NodeNames.PAGE_CONTENT)) {
			GuiElementDefinitionParser widgetsParser = delegate.getScreenElementDefinitionParser(NodeNames.PAGE_CONTENT);
			PageContentComponent pageContent = (PageContentComponent) widgetsParser.parse(element);
			getUiRoot().setPageContent(pageContent);
		}	
	}
	
	/**
	 * Parse the PreActions Node and return the PreActions Component that can be
	 * set in the Component Tree.
	 * @param element
	 * @param delegate
	 * @return PreRenderActions created from the parsed XML Node.
	 */
	private PreRenderActions parsePreActions(Element element,ScreenDefinitionParserDelegate delegate) {
		GuiElementDefinitionParser parser = delegate.getScreenElementDefinitionParser(ParserConstants.PRE_ACTIONS_PARSER);
		PreRenderActions preActions = (PreRenderActions) parser.parse(element);
		return preActions;
	}

	/**
	 * @return the uiRoot
	 */
	public GuiRootComponent getUiRoot() {
		return uiRoot;
	}

	/**
	 * @param uiRoot the uiRoot to set
	 */
	public void setUiRoot(GuiRootComponent uiRoot) {
		this.uiRoot = uiRoot;
	}

}
