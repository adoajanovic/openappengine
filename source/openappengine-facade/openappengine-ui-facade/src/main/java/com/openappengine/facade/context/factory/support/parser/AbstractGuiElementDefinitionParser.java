/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.w3c.dom.Node;

import com.openappengine.facade.context.factory.support.ScreenDefinitionParserDelegate;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public abstract class AbstractGuiElementDefinitionParser implements GuiElementDefinitionParser {

	private ScreenDefinitionParserDelegate delegate;
	
	protected static final String ELEMENT_PRE_ACTIONS = "pre-actions";
	
	protected static final String ELEMENT_FIELD_MAP = "FIELD_MAP";
	
	protected static final String ACTION_ENTITY_FIND_ONE = "entity-find-one";

	/**
	 * @param delegate
	 */
	protected AbstractGuiElementDefinitionParser() {
	}
	
	protected GuiElementDefinitionParser getScreenElementDefinitionParser(String name) {
		return this.getDelegate().getScreenElementDefinitionParser(name);
	}
	
	protected abstract boolean isNodeParseable(String nodeName);

	/**
	 * Get the appropriate parser for this node.
	 * @param node
	 */
	protected GuiElementDefinitionParser createNodeParserDelegate(Node node) {
		String nodeName = node.getNodeName();
		GuiElementDefinitionParser parser = getScreenElementDefinitionParser(nodeName);
		return parser;
	}

	/**
	 * @return the delegate
	 */
	protected ScreenDefinitionParserDelegate getDelegate() {
		return delegate;
	}

	/**
	 * @param delegate the delegate to set
	 */
	public void setDelegate(ScreenDefinitionParserDelegate delegate) {
		this.delegate = delegate;
	}
}
