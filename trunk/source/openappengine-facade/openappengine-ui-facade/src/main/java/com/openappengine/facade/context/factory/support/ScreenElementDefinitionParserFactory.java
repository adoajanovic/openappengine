/**
 * 
 */
package com.openappengine.facade.context.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.Factory;

import com.openappengine.facade.context.factory.support.parser.ScreenElementDefinitionParser;

/**
 * ScreenElementDefinitionParserFactory provides the ScreenElementDefinitionParsers
 * from their XML Node Names.
 * 
 * @author hrishi
 * since Dec 31, 2011
 */
public class ScreenElementDefinitionParserFactory implements Factory {
	
	//XML Node Constants
	public static final String ENTITY_FIND_ONE = "entity-find-one";

	public static final String PRE_ACTIONS = "pre-actions";

	public static final String FIELD_MAP = "field-map"; 
	
	private Map<String, ScreenElementDefinitionParser> screenElementDefinitionParserMap = new ConcurrentHashMap<String, ScreenElementDefinitionParser>();

	@Override
	public ScreenElementDefinitionParser create() {
		throw new UnsupportedOperationException("Use the method getScreenElementDefinitionParser instead of this operation.");
	}
	
	public ScreenElementDefinitionParser getScreenElementDefinitionParser(String name) {
		return getScreenElementDefinitionParserMap().get(name);
	}

	public Map<String, ScreenElementDefinitionParser> getScreenElementDefinitionParserMap() {
		return screenElementDefinitionParserMap;
	}

	public void addScreenElementDefinitionParser(String name, ScreenElementDefinitionParser parser) {
		screenElementDefinitionParserMap.put(name, parser);
	}
}
