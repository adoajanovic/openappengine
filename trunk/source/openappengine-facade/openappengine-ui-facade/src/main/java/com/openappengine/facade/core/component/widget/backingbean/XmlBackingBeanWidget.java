/**
 * 
 */
package com.openappengine.facade.core.component.widget.backingbean;

import org.w3c.dom.Document;

/**
 * @author hrishikesh.joshi
 * @since  Feb 7, 2012
 *
 */
public interface XmlBackingBeanWidget extends BackingBeanWidget {
	
	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Document formBackingObject();


}
