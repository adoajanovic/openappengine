/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support;

import org.springframework.util.Assert;
import org.w3c.dom.Node;

import com.openappengine.gui.engine.context.factory.FactoryConstants;
import com.openappengine.gui.engine.context.factory.FactoryFinder;
import com.openappengine.gui.engine.context.factory.support.parser.GuiElementDefinitionParser;

/**
 * Delegate to parse the Xml Definitions. 
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class ScreenDefinitionParserDelegate {
	
	private static ScreenElementDefinitionParserFactory factory;
	
	public ScreenDefinitionParserDelegate() {
		super();
		createNodeDefinitionParserFactory();
	}

	private void createNodeDefinitionParserFactory() {
		if(factory == null) {
			ScreenElementDefinitionParserFactoryInitializer initializer = new ScreenElementDefinitionParserFactoryInitializer();
			setFactory((ScreenElementDefinitionParserFactory) FactoryFinder.getFactory(FactoryConstants.SCREEN_ELEMENT_DEFINITION_PARSER_FACTORY, initializer));
		}
	}
	
	/**
	 * Used to check if the node name of the XML Node is equal to the Screen XSD defined
	 * element and parse accordingly.
	 * 
	 * @param node
	 * @param nodeName
	 * @return NodeName equals the XML Node Name parsed currently.
	 */
	public boolean nodeNameEquals(Node node,String nodeName) {
		return nodeName.equals(node.getNodeName());
	}
	
	public GuiElementDefinitionParser getScreenElementDefinitionParser(String name) {
		GuiElementDefinitionParser parser = factory.getScreenElementDefinitionParser(name);
		Assert.notNull(parser,"ScreenElementDefinitionParser : " + name + " not configured.");
		parser.setDelegate(this);
		return parser;
	}
	
	protected ScreenElementDefinitionParserFactory getFactory() {
		return factory;
	}

	protected static void setFactory(ScreenElementDefinitionParserFactory factory) {
		ScreenDefinitionParserDelegate.factory = factory;
	}
}
