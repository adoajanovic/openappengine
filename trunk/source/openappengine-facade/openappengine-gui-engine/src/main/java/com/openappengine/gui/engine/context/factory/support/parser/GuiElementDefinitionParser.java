/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.context.factory.support.ScreenDefinitionParserDelegate;
import com.openappengine.gui.engine.core.component.GuiComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public interface GuiElementDefinitionParser {

	/**
	 * Used to parse individual sub nodes of the entire XML Definition.
	 * @param element
	 * @return
	 */
	GuiComponent parse(Element element);
	
	<T extends GuiComponent> T parse(Element element, Class<T> t);
	
	void setDelegate(ScreenDefinitionParserDelegate delegate);
	
	String getParsedNodeName();
}
