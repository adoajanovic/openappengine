/**
 * 
 */
package com.openappengine.facade.core.context;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.TransitionHandler;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.renderer.WebXmlScreenRenderer;

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
		screenRenderer = new WebXmlScreenRenderer();
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
