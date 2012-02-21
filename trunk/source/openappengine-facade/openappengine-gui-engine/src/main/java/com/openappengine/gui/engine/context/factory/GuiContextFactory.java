/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.gui.engine.core.context.GuiApplicationContext;

/**
 * The Factory is initialized from the listener and 
 * the same instance of this factory is queried for loading subsequent screens.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface GuiContextFactory {
	
	/**
	 * Is the Screen at the given resournce present in the factory.
	 * @param resource
	 * @return
	 */
	boolean contains(Resource resource);
	
	/**
	 * Get ScreenApplicationContext from the factory.
	 * @param resource
	 * @return
	 */
	GuiApplicationContext createGuiApplicationContext(Resource resource);
	
	/**
	 * Register the ScreenApplicationContext with the factory.
	 * @param resource
	 * @param context
	 */
	void registerScreenApplicationContext(Resource resource,GuiApplicationContext context);
	
	/**
	 * @param resource
	 * @return
	 */
	GuiApplicationContext getApplicationContext(Resource resource);

	/**
	 * @param applicationContext
	 */
	void processLifecylePreRenderActions(GuiApplicationContext applicationContext);

	/**
	 * @param applicationContext
	 */
	void processLifecycleInitializedEvent(GuiApplicationContext applicationContext);
	
	public void processLifecycleTransformWidgetsEvent(GuiApplicationContext applicationContext);
	
	void processLifecylePostRestoreProcessing(GuiApplicationContext applicationContext);

	void refreshMessages(GuiApplicationContext context);
}
