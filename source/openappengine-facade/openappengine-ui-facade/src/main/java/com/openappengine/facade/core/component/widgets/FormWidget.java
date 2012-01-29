/**
 * 
 */
package com.openappengine.facade.core.component.widgets;

import java.io.Serializable;

/**
 * @author hrishi
 * since Jan 13, 2012
 */
public interface FormWidget extends Serializable {

	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Object formBackingObject();
	
	
	/**
	 * @return Entity Name
	 */
	String getEntityName();
}
