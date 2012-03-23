/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import java.io.Serializable;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.TransitionHandler;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.ActionExecutor;
import com.openappengine.gui.engine.core.renderer.ScreenRenderer;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class ContextConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TransitionHandler transitionHandler;
	
	private ScreenRenderer screenRenderer;
	
	private ActionExecutor actionExecutor;
	
	private ELContext elContext;
	
	private MessageContext messageContext;

	public TransitionHandler getTransitionHandler() {
		return transitionHandler;
	}

	public void setTransitionHandler(TransitionHandler transitionHandler) {
		this.transitionHandler = transitionHandler;
	}

	public ScreenRenderer getScreenRenderer() {
		return screenRenderer;
	}

	public void setScreenRenderer(ScreenRenderer screenRenderer) {
		this.screenRenderer = screenRenderer;
	}

	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}

	public void setActionExecutor(ActionExecutor actionExecutor) {
		this.actionExecutor = actionExecutor;
	}

	public ELContext getElContext() {
		return elContext;
	}

	public void setElContext(ELContext elContext) {
		this.elContext = elContext;
	}

	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}
}
