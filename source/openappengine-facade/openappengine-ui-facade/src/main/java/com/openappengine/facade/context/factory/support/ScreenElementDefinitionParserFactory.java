/**
 * 
 */
package com.openappengine.facade.context.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.facade.context.factory.support.parser.GuiElementDefinitionParser;

/**
 * ScreenElementDefinitionParserFactory provides the ScreenElementDefinitionParsers
 * from their XML Node Names.
 * 
 * @author hrishi
 * since Dec 31, 2011
 */
public class ScreenElementDefinitionParserFactory {
	
	//XML Node Constants
	public static final String ENTITY_FIND_ONE = "entity-find-one";

	public static final String PRE_ACTIONS = "pre-actions";

	public static final String FIELD_MAP = "field-map"; 
	
	private Map<String, GuiElementDefinitionParser> screenElementDefinitionParserMap = new ConcurrentHashMap<String, GuiElementDefinitionParser>();

	public GuiElementDefinitionParser getScreenElementDefinitionParser(String name) {
		return getScreenElementDefinitionParserMap().get(name);
	}

	public Map<String, GuiElementDefinitionParser> getScreenElementDefinitionParserMap() {
		return screenElementDefinitionParserMap;
	}

	public void addScreenElementDefinitionParser(String name, GuiElementDefinitionParser parser) {
		screenElementDefinitionParserMap.put(name, parser);
	}
}
