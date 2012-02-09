/**
 * 
 */
package com.openappengine.facade.core.component.widget.context;

/**
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public interface HibernateBackingBeanWigetProcessorContext extends
		WidgetProcessorContext {

	Class<?> getWidgetBackingClass();
	
	String getWidgetBackingObjectValueRef();
	
}
