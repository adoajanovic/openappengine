/**
 * 
 */
package com.openappengine.gui.engine.core.renderer;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebXmlScreenRenderer implements ScreenRenderer {
	
	private GuiEngineContext context;
	
	@Override
	public void setGuiApplicationContext(GuiEngineContext screenApplicationContext) {
		this.context = screenApplicationContext;
	}

}
