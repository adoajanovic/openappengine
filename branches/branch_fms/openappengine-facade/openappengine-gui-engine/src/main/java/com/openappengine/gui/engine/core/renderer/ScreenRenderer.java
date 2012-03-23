/**
 * 
 */
package com.openappengine.gui.engine.core.renderer;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.GuiApplicationContextAware;

/**
 * Renderer that is called from the XmlScreenProcessor. 
 * The ScreenRenderer uses the ScreenApplicationContext 
 * to render the Screen Specific to the underlying framework used.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ScreenRenderer extends GuiApplicationContextAware{
	
	/**
	 * Set the Screen Application context.
	 * @param screenApplicationContext
	 */
	void setGuiApplicationContext(GuiEngineContext screenApplicationContext);

}
