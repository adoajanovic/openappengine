/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.Serializable;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.TransitionHandler;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.renderer.ScreenRenderer;

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
}
