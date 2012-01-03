/**
 * 
 */
package com.openappengine.facade.context.factory;

import com.openappengine.facade.core.ScreenTransitionHandler;
import com.openappengine.facade.core.el.DefaultJexlContext;
import com.openappengine.facade.core.executor.DefaultActionExecutor;
import com.openappengine.facade.core.renderer.WebXmlScreenRenderer;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class DefaultContextConfiguration extends ContextConfiguration {
	
	private static final long serialVersionUID = 1L;

	public DefaultContextConfiguration() {
		setDefaults();
	}

	protected void setDefaults() {
		this.setActionExecutor(new DefaultActionExecutor());
		this.setScreenRenderer(new WebXmlScreenRenderer());
		this.setTransitionHandler(new ScreenTransitionHandler());
		this.setElContext(new DefaultJexlContext());
	}
		
}
