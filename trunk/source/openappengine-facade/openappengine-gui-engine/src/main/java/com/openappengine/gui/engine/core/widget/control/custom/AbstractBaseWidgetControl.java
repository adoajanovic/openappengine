/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control.custom;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.WidgetControlRenderer;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public abstract class AbstractBaseWidgetControl implements WidgetControlRenderer {
	
	@Override
	public void encodeChildren(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		//DO NOTHING
	}

	/**
	 * @param element
	 * @param writer
	 */
	protected void writeNameAttribute(Element element, WidgetControlWriter writer) {
		writer.writeAttribute("name", element.getAttribute("path"));
	}

	/**
	 * @param element
	 * @param writer
	 */
	protected void writeIdAttribute(Element element, WidgetControlWriter writer) {
		writer.writeAttribute("id", element.getAttribute("id"));
	}
	
	/**
	 * @param element
	 * @param writer
	 */
	protected void writeLabelIdAttribute(Element element, WidgetControlWriter writer) {
		writer.writeAttribute("labelId", element.getAttribute("labelId"));
	}
	
	/**
	 * @param element
	 * @param writer
	 */
	protected void writeRequiredAttribute(Element element,
			WidgetControlWriter writer) {
		writer.writeAttribute("required", element.getAttribute("required"));
	}
	
	protected void writePathAttribute(Element element,WidgetControlWriter writer) {
		writer.writeAttribute("path", element.getAttribute("path"));
	}
	
	

}
