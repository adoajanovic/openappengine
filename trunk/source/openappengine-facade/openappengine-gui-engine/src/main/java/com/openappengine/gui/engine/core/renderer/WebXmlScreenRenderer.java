/**
 * 
 */
package com.openappengine.gui.engine.core.renderer;

import com.openappengine.gui.engine.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebXmlScreenRenderer implements ScreenRenderer {
	
	private GuiApplicationContext context;
	
	@Override
	public void setGuiApplicationContext(GuiApplicationContext screenApplicationContext) {
		this.context = screenApplicationContext;
	}

}
