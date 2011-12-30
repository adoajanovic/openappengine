/**
 * 
 */
package com.openappengine.facade.core.renderer;

import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebXmlScreenRenderer implements ScreenRenderer {
	
	private ScreenApplicationContext context;
	
	@Override
	public void setScreenApplicationContext(ScreenApplicationContext screenApplicationContext) {
		this.context = screenApplicationContext;
	}

}
