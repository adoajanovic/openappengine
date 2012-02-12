/**
 * 
 */
package com.openappengine.facade.core.widget.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.fsm.TransitionEventListener;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public interface WidgetProcessorContextFactory {
	
	/**
	 * Create WidgetProcessorContext
	 * @param externalContext
	 * @return
	 */
	WidgetProcessorContext createWidgetProcessorContext(ExternalContext externalContext,ELContext elContext,TransitionEventListener transitionEventListener,MessageContext messageContext);

}
