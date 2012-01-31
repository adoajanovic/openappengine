/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.renderer.WebXmlScreenRenderer;
import com.openappengine.facade.fsm.WebTransitionEventListener;
import com.openappengine.facade.fsm.TransitionEventListener;

/**
 * The XmlScreenApplicationContext for the Web JEE Environment.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebGuiApplicationContext extends AbstractGuiApplicationContext {

	protected ScreenRenderer screenRenderer;
	
	protected ExternalContext externalContext;
	
	protected TransitionEventListener transitionEventListener;
	
	public WebGuiApplicationContext() {
	}

	/**
	 * Initializations for the JEE environment.
	 */
	public void postRootConstruction() {
		screenRenderer = new WebXmlScreenRenderer();
		transitionEventListener = new WebTransitionEventListener(getUIRoot());
		transitionEventListener.setExpressionEvaluator(getExpressionEvaluator());
	}
	
	@Override
	public ScreenRenderer getScreenRenderer() {
		return screenRenderer;
	}

	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}

	@Override
	public TransitionEventListener getTransitionEventListener() {
		return transitionEventListener;
	}

	/**
	 * @param transitionEventListener the transitionEventListener to set
	 */
	public void setTransitionEventListener(TransitionEventListener transitionEventListener) {
		this.transitionEventListener = transitionEventListener;
	}

	@Override
	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}
	
}
