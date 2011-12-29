/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import org.springframework.core.io.Resource;

import com.openappengine.facade.ui.core.ExternalContext;
import com.openappengine.facade.ui.core.TransitionHandler;
import com.openappengine.facade.ui.core.renderer.ScreenRenderer;
import com.openappengine.facade.ui.core.renderer.WebXmlScreenRenderer;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebXmlScreenApplicationContext extends AbstractXmlScreenApplicationContext {

	protected TransitionHandler transitionHandler;
	
	protected ExternalContext externalContext;
	
	protected ScreenRenderer screenRenderer;
	
	/**
	 * @param resource
	 */
	public WebXmlScreenApplicationContext(Resource resource,ExternalContext externalContext) {
		super(resource);
		this.externalContext = externalContext;
		initWebScreenApplicationContext();
	}

	/**
	 * Initializations for the JEE environment.
	 */
	protected void initWebScreenApplicationContext() {
		screenRenderer = new WebXmlScreenRenderer(this);
	}
	
	@Override
	public TransitionHandler getTransitionHandler() {
		return transitionHandler;
	}

	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}

	@Override
	public ScreenRenderer getScreenRenderer() {
		return screenRenderer;
	}

}
