/**
 * 
 */
package com.openappengine.facade.core.component.widget.backingbean;

/**
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public interface PojoBackingBeanWidget extends BackingBeanWidget {

	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Object formBackingObject();
	
}
