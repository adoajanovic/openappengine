/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.gui.engine.context.factory.support.parser.GuiElementDefinitionParser;

/**
 * ScreenElementDefinitionParserFactory provides the ScreenElementDefinitionParsers
 * from their XML Node Names.
 * 
 * @author hrishi
 * since Dec 31, 2011
 */
public class ScreenElementDefinitionParserFactory {
	
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
