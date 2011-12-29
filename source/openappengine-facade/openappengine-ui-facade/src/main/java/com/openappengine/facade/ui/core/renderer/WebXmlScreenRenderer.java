/**
 * 
 */
package com.openappengine.facade.ui.core.renderer;

import com.openappengine.facade.ui.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebXmlScreenRenderer implements ScreenRenderer {
	
	private ScreenApplicationContext context;
	
	public WebXmlScreenRenderer(ScreenApplicationContext context) {
		setScreenApplicationContext(context);
	}

	@Override
	public void setScreenApplicationContext(ScreenApplicationContext screenApplicationContext) {
		this.context = screenApplicationContext;
	}

}
