/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import org.w3c.dom.Element;


/**
 * @author hrishi
 * since Feb 25, 2012
 */
public interface WidgetControlWriter {
	
	void startElement(String tagName);
	
	void endElement(String tagName);
	
	void writeAttribute(String attr,String value);
	
	void writeValue(String value);
	
	Element getWidgetControlElement();
}
