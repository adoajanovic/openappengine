/**
 * 
 */
package com.openappengine.facade.core.context;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface GuiApplicationContextAware {

	/**
	 * Set the Screen Application Context
	 * @param context
	 */
	void setGuiApplicationContext(GuiApplicationContext context);
	
}
