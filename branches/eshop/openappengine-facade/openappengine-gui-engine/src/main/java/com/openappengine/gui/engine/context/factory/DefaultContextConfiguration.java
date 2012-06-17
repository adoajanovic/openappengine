/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import com.openappengine.gui.engine.core.DefaultTransitionHandler;
import com.openappengine.gui.engine.core.el.DefaultJexlContext;
import com.openappengine.gui.engine.core.executor.DefaultActionExecutor;
import com.openappengine.gui.engine.core.renderer.WebXmlScreenRenderer;

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
		this.setTransitionHandler(new DefaultTransitionHandler());
		this.setElContext(new DefaultJexlContext());
	}
		
}
