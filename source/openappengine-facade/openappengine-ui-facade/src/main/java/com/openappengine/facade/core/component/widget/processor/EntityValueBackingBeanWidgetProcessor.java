/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishikesh.joshi
 * @since  Feb 2, 2012
 *
 */
public interface EntityValueBackingBeanWidgetProcessor extends BackingBeanWidgetProcessor {
	
	/**
	 * @param context
	 * @return Object returned by the WidgetProcessor
	 */
	EntityValue processWidget();

}
