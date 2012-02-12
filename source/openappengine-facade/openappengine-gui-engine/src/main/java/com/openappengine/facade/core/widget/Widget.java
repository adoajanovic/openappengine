/**
 * 
 */
package com.openappengine.facade.core.widget;

import java.io.Serializable;

import org.w3c.dom.Document;

import com.openappengine.facade.core.component.ui.ValueRefAware;

/**
 * The WidgetType Interface is the root of all the Form Widgets. 
 * 
 * The property widgetMode decides the Processor, Action Handler for this WidgetType.
 * 
 * @author hrishi
 * since Jan 13, 2012
 */
public interface Widget extends Serializable,ValueRefAware<Document> {

	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Object formBackingObject();
	
	/**
	 * @return WidgetType Type.
	 */
	String getWidgetType();
}
