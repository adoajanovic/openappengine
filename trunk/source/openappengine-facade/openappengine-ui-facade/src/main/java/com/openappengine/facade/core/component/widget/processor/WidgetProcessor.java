/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public interface WidgetProcessor {
	
	/**
	 * @return WidgetType which can be processed by this processor. 
	 */
	String getProcessedWidgetType();
	
	/**
	 * @param context
	 */
	void setWidgetProcessorContext(WidgetProcessorContext context);
	
	
	/**
	 * @return
	 */
	Class<?> getWidgetProcessorContextClass();
	

	/**
	 * @param context
	 * @return Object returned by the WidgetProcessor
	 */
	Object processWidget();
}
