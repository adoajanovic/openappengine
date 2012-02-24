/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import com.openappengine.gui.engine.context.factory.support.ScreenDefinitionParserDelegate;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public abstract class AbstractGuiElementDefinitionParser implements GuiElementDefinitionParser {

	private ScreenDefinitionParserDelegate delegate;
	
	protected static final String ELEMENT_PRE_ACTIONS = "pre-actions";
	
	protected static final String ACTION_ENTITY_FIND_ONE = "entity-find-one";
	
	protected static final String ELEMENT_FIELD_MAP = "FIELD_MAP";
	
	protected static final Logger logger = Logger.getLogger("ElementDefinitionParser");

	/**
	 * @param delegate
	 */
	protected AbstractGuiElementDefinitionParser() {
	}
	
	protected GuiElementDefinitionParser getScreenElementDefinitionParser(String name) {
		return this.getDelegate().getScreenElementDefinitionParser(name);
	}
	
	protected boolean isNodeParseable(String nodeName) {
		return StringUtils.equals(nodeName, getParsedNodeName());
	}

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
