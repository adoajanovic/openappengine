/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import org.springframework.util.Assert;
import org.w3c.dom.Element;

import com.openappengine.utility.UtilXml;


/**
 * @author hrishi
 * since Feb 25, 2012
 */
public class DefaultWidgetControlWriter implements WidgetControlWriter {
	
	private Element parentEle;
	
	private Element widgetControlElement;
	
	public DefaultWidgetControlWriter(Element parent) {
		Assert.notNull(parent, "Element Cannot be null.");
		parentEle = parent;
	}

	@Override
	public void startElement(String tagName) {
		widgetControlElement = parentEle.getOwnerDocument().createElement(tagName);
	}

	private void verifyElement() {
		if(widgetControlElement == null) {
			throw new IllegalStateException("startElement not called.");
		}
	}
	@Override
	public void endElement(String tagName) {
		verifyElement();
	}

	@Override
	public void writeAttribute(String attr, String value) {
		verifyElement();
		widgetControlElement.setAttribute(attr, value);
	}

	@Override
	public void writeValue(String value) {
		verifyElement();
		widgetControlElement.setTextContent(value);
	}

	@Override
	public Element getWidgetControlElement() {
		return widgetControlElement;
	}

}
