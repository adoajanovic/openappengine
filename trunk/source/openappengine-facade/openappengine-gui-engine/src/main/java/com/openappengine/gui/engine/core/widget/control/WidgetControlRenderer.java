/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;


/**
 * @author hrishi
 * since Feb 26, 2012
 */
public interface WidgetControlRenderer {

	public void encodeBegin(Element element,GuiEngineContext context, WidgetControlWriter writer);
	
	public void encodeEnd(Element element,GuiEngineContext context, WidgetControlWriter writer);
	
	public void encodeChildren(Element element,GuiEngineContext context, WidgetControlWriter writer);
	
	public boolean rendersChildren();

}
