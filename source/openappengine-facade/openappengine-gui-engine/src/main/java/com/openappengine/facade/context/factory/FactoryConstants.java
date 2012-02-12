/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.Serializable;

/**
 * FactoryConstants hold the factory names for all the factories associated with the FactoryFinder interface.
 * 
 * @author hrishi
 * since Dec 31, 2011
 */
public class FactoryConstants implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *  XML Screen Application Context Factory.
	 */
	public static final String XML_SCREEN_APPLICATION_CONTEXT_FACTORY = "XmlScreenApplicationContextFactory";
	
	/**
	 *  XML Screen Elements Parser Factory
	 */
	public static final String SCREEN_ELEMENT_DEFINITION_PARSER_FACTORY = "ScreenElementDefinitionParserFactory";

	/**
	 *  Action Handler Factory
	 */
	public static final String ACTION_HANDLER_FACTORY = "ActionHandlerFactory";
	
	/**
	 *  Action Context Factory
	 */
	public static final String ACTION_CONTEXT_FACTORY = "ActionContextFactory";
	
}
