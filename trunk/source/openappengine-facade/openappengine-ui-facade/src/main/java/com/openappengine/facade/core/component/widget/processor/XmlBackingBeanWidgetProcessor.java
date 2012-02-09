/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;

/**
 * @author hrishikesh.joshi
 * @since  Feb 7, 2012
 *
 */
public abstract class XmlBackingBeanWidgetProcessor implements WidgetProcessor {
	
	private WidgetProcessorContext context;

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		this.context = context;
	}

	@Override
	public Class<?> getWidgetProcessorContextClass() {
		return context.getClass();
	}

	@Override
	public Object processWidget() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
