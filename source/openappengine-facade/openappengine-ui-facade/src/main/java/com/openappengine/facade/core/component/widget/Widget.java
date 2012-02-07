/**
 * 
 */
package com.openappengine.facade.core.component.widget;

import java.io.Serializable;

/**
 * The Widget Interface is the root of all the Form Widgets. 
 * 
 * The property widgetMode decides the Processor, Action Handler for this Widget.
 * 
 * @author hrishi
 * since Jan 13, 2012
 */
public interface Widget extends Serializable {

	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Object formBackingObject();
	
	/**
	 * @return widget mode.
	 */
	String getWidgetMode();
	
	/**
	 * @return Entity Name
	 */
	String getEntityName();
	
	/**
	 * @return Widget Type.
	 */
	String getWidgetType();
}
