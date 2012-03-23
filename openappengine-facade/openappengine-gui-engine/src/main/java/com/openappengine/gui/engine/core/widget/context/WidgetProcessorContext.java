/**
 * 
 */
package com.openappengine.gui.engine.core.widget.context;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public interface WidgetProcessorContext {
	
	String getWidgetId();
	
	String getTriggeredTransition();
	
	String getWidgetType();

	ExternalContext getExternalContext();
	
	ELContext getELContext();
	
	MessageContext getMessageContext();

	TransitionEventListener getTransitionEventListener();
	
	Class<?> getWidgetBackingClass();
	
	String getWidgetBackingObjectValueRef();
}
