/**
 * 
 */
package com.openappengine.facade.context.factory;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ScreenApplicationContextFactoryAware {
	
	/**
	 * Set the ScreenApplicationContextFactory.
	 * @param factory
	 */
	void setScreenApplicationContextFactory(GuiContextFactory factory);

}
