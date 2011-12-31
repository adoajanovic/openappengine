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
