package com.openappengine.gui.engine.core.widget.context;

import javax.servlet.http.HttpServletRequest;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

public class HttpServletWidgetProcessorContextFactory implements WidgetProcessorContextFactory {

	@Override
	public WidgetProcessorContext createWidgetProcessorContext(ExternalContext externalContext,ELContext elContext,TransitionEventListener transitionEventListener,MessageContext messageContext) {
		if(externalContext == null) {
			throw new IllegalArgumentException("External Context cannot be null.");
		}
		
		if(externalContext.getRequest() instanceof HttpServletRequest) {
			
			WidgetProcessorContext context = new HttpServletWidgetProcessorContext(
					externalContext, elContext, transitionEventListener,messageContext);
			return context;
		}
		
		return null;
	}

}
