/**
 * 
 */
package com.openappengine.facade.core.renderer;

import com.openappengine.facade.core.context.ScreenApplicationContext;
import com.openappengine.facade.core.context.ScreenApplicationContextAware;

/**
 * Renderer that is called from the XmlScreenProcessor. 
 * The ScreenRenderer uses the ScreenApplicationContext 
 * to render the Screen Specific to the underlying framework used.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ScreenRenderer extends ScreenApplicationContextAware{
	
	/**
	 * Set the Screen Application context.
	 * @param screenApplicationContext
	 */
	void setScreenApplicationContext(ScreenApplicationContext screenApplicationContext);

}
