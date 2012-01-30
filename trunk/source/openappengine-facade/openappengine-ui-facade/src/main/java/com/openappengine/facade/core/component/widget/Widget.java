/**
 * 
 */
package com.openappengine.facade.core.component.widget;

import java.io.Serializable;

/**
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
	 * @return Entity Name
	 */
	String getEntityName();
	
	/**
	 * @return Widget Type.
	 */
	String getWidgetType();
}
