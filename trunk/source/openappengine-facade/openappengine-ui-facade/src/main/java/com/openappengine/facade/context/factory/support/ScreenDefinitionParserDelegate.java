/**
 * 
 */
package com.openappengine.facade.context.factory.support;

import org.springframework.util.Assert;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.context.factory.support.parser.EntityFindOneActionElementDefinitionParser;
import com.openappengine.facade.context.factory.support.parser.FieldMapComponentDefinitionParser;
import com.openappengine.facade.context.factory.support.parser.PreActionsElementParser;
import com.openappengine.facade.context.factory.support.parser.GuiElementDefinitionParser;

/**
 * Delegate to parse the Xml Definitions. 
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class ScreenDefinitionParserDelegate {
	
	private Element root;
	
	private ScreenElementDefinitionParserFactory factory;
	
	public ScreenDefinitionParserDelegate(Element root) {
		super();
		this.setRoot(root);
		createNodeDefinitionParserFactory();
	}

	private void createNodeDefinitionParserFactory() {
		ScreenElementDefinitionParserFactoryInitializer initializer = new ScreenElementDefinitionParserFactoryInitializer();
		setFactory((ScreenElementDefinitionParserFactory) FactoryFinder.getFactory(FactoryConstants.SCREEN_ELEMENT_DEFINITION_PARSER_FACTORY, initializer));
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
	
	public Element getRoot() {
		return root;
	}

	public void setRoot(Element root) {
		this.root = root;
	}

	protected ScreenElementDefinitionParserFactory getFactory() {
		return factory;
	}

	protected void setFactory(ScreenElementDefinitionParserFactory factory) {
		this.factory = factory;
	}
	
	private class ScreenElementDefinitionParserFactoryInitializer implements Callback<ScreenElementDefinitionParserFactory> {

		@Override
		public ScreenElementDefinitionParserFactory onCallback() {
			ScreenElementDefinitionParserFactory factory = new ScreenElementDefinitionParserFactory();
			factory.addScreenElementDefinitionParser(ScreenElementDefinitionParserFactory.ENTITY_FIND_ONE, new EntityFindOneActionElementDefinitionParser());
			factory.addScreenElementDefinitionParser(ScreenElementDefinitionParserFactory.FIELD_MAP, new FieldMapComponentDefinitionParser());
			factory.addScreenElementDefinitionParser(ScreenElementDefinitionParserFactory.PRE_ACTIONS, new PreActionsElementParser());
			return factory;
		}
		
	}
}
