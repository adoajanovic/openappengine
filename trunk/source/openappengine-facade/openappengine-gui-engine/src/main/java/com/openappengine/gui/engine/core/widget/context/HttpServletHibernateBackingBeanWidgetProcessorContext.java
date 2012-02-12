/**
 * 
 */
package com.openappengine.gui.engine.core.widget.context;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ClassUtils;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.ext.ExternalWebContext;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class HttpServletHibernateBackingBeanWidgetProcessorContext implements WidgetProcessorContext {
	
	private HttpServletRequest httpServletRequest;
	
	private ELContext elContext;
	
	private TransitionEventListener transitionEventListener;
	
	private ExternalContext externalContext;
	
	private MessageContext messageContext;
	
	/**
	 * @param httpServletRequest
	 */
	public HttpServletHibernateBackingBeanWidgetProcessorContext(ExternalContext externalContext,ELContext elContext,TransitionEventListener transitionEventListener,MessageContext messageContext) {
		super();
		if(externalContext instanceof ExternalWebContext) {
			httpServletRequest = (HttpServletRequest) externalContext.getRequest();
		}
		
		this.elContext = elContext;
		this.externalContext = externalContext;
		this.transitionEventListener = transitionEventListener;
		this.messageContext = messageContext;
	}

	@Override
	public Class<?> getWidgetBackingClass() {
		String widgetBackingClassName = httpServletRequest.getParameter("widgetClass");
		if(StringUtils.isNotEmpty(widgetBackingClassName)) {
			try {
				Class<?> formBackingClass = ClassUtils.forName(widgetBackingClassName, getClass().getClassLoader());
				return formBackingClass;
			} catch (Throwable e) {
				e.printStackTrace();
			} 
		}
		return null;
	}

	@Override
	public String getWidgetId() {
		return httpServletRequest.getParameter("widgetId");
	}

	@Override
	public String getTriggeredTransition() {
		return httpServletRequest.getParameter("widgetTransition");
	}

	@Override
	public String getWidgetBackingObjectValueRef() {
		return httpServletRequest.getParameter("widgetValueRef");
	}

	@Override
	public String getWidgetType() {
		return httpServletRequest.getParameter("widgetType");
	}

	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}

	@Override
	public ELContext getELContext() {
		return elContext;
	}

	@Override
	public TransitionEventListener getTransitionEventListener() {
		return transitionEventListener;
	}

	/**
	 * @return the httpServletRequest
	 */
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	/**
	 * @param httpServletRequest the httpServletRequest to set
	 */
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	/**
	 * @return the elContext
	 */
	public ELContext getElContext() {
		return elContext;
	}

	/**
	 * @param elContext the elContext to set
	 */
	public void setElContext(ELContext elContext) {
		this.elContext = elContext;
	}

	/**
	 * @param transitionEventListener the transitionEventListener to set
	 */
	public void setTransitionEventListener(
			TransitionEventListener transitionEventListener) {
		this.transitionEventListener = transitionEventListener;
	}

	/**
	 * @param externalContext the externalContext to set
	 */
	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	@Override
	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}
}
