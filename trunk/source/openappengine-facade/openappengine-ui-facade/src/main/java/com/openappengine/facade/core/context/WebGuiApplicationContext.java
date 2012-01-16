/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.TransitionHandler;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.renderer.WebXmlScreenRenderer;

/**
 * The XmlScreenApplicationContext for the Web JEE Environment.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebGuiApplicationContext extends AbstractGuiApplicationContext {

	protected TransitionHandler transitionHandler;
	
	protected ScreenRenderer screenRenderer;
	
	protected ExternalContext externalContext;
	
	public WebGuiApplicationContext(ExternalContext externalContext) {
		initWebGuiApplicationContext();
		
		this.externalContext = externalContext;
	}

	/**
	 * Initializations for the JEE environment.
	 */
	protected void initWebGuiApplicationContext() {
		screenRenderer = new WebXmlScreenRenderer();
	}
	
	@Override
	public TransitionHandler getTransitionHandler() {
		return transitionHandler;
	}

	@Override
	public ScreenRenderer getScreenRenderer() {
		return screenRenderer;
	}

	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}
}