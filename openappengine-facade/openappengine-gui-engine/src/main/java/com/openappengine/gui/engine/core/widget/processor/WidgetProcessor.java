/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor;

import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContext;

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
	 * @param context
	 * @return Object returned by the WidgetProcessor
	 */
	Object processWidget();
}
