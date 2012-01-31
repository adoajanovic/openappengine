package com.openappengine.facade.core.component.widget.context;

import javax.servlet.http.HttpServletRequest;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.fsm.TransitionEventListener;

public class HttpServletWidgetProcessorContextFactory implements WidgetProcessorContextFactory {

	@Override
	public WidgetProcessorContext createWidgetProcessorContext(ExternalContext externalContext,ELContext elContext,TransitionEventListener transitionEventListener,MessageContext messageContext) {
		if(externalContext == null) {
			throw new IllegalArgumentException("External Context cannot be null.");
		}
		
		if(externalContext.getRequest() instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();
			HttpServletWidgetProcessorContext context = new HttpServletWidgetProcessorContext(externalContext,elContext,transitionEventListener,messageContext);
			
			return context;
		}
		
		return null;
	}

}
