/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import com.openappengine.facade.core.component.widget.context.HibernateBackingBeanWigetProcessorContext;
import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;

/**
 * @author hrishikesh.joshi
 * @since  Feb 2, 2012
 *
 */
public abstract class HibernateEntityValueBackingBeanWidgetProcessor implements EntityValueBackingBeanWidgetProcessor {

	protected HibernateBackingBeanWigetProcessorContext widgetProcessorContext;
	
	@Override
	public Class<?> getWidgetProcessorContextClass() {
		return HibernateBackingBeanWigetProcessorContext.class;
	}

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		if(context == null) {
			throw new IllegalArgumentException("WidgetProcessorContext cannot be null.");
		}
		if(!supportsWidgetProcessorContext(context.getClass())) {
			throw new IllegalArgumentException(
					"WidgetProcessor does not support the WidgetProcessorContext class:"
							+ context.getClass()
							+ ". Should extend from "
							+ HibernateBackingBeanWigetProcessorContext.class
									.getName() + ".");
		}
		this.widgetProcessorContext = (HibernateBackingBeanWigetProcessorContext) context;
	}

	public boolean supportsWidgetProcessorContext(Class<?> clazz) {
		if(clazz == null || getWidgetProcessorContextClass() == null) {
			return false;
		}
		return getWidgetProcessorContextClass().isAssignableFrom(clazz);
	}

	protected HibernateBackingBeanWigetProcessorContext getWidgetProcessorContext() {
		return widgetProcessorContext;
	}	
}
