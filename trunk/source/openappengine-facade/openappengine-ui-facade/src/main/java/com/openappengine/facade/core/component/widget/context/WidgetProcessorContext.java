/**
 * 
 */
package com.openappengine.facade.core.component.widget.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.fsm.TransitionEventListener;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public interface WidgetProcessorContext {
	
	Class<?> getWidgetBackingClass();
	
	String getWidgetId();
	
	String getTriggeredTransition();
	
	String getWidgetBackingObjectValueRef();
	
	String getWidgetBackingObjectEntityName();
	
	String getWidgetType();

	ExternalContext getExternalContext();
	
	ELContext getELContext();

	TransitionEventListener getTransitionEventListener();
}
