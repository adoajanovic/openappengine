/**
 * 
 */
package com.openappengine.facade.core.widget.processor;

/**
 * @author hrishikesh.joshi
 * @since  Feb 2, 2012
 *
 */
public interface BackingBeanWidgetProcessor extends WidgetProcessor {
	
	/**
	 * @param context
	 * @return Object returned by the WidgetProcessor
	 */
	Object processWidget();

}
