/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

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
	GuiEngineContext createGuiEngineContext(Resource resource);
	
	/**
	 * Register the ScreenApplicationContext with the factory.
	 * @param resource
	 * @param context
	 */
	void registerGuiEngineContext(Resource resource,GuiEngineContext context);
	
	/**
	 * @param resource
	 * @return
	 */
	GuiEngineContext getApplicationContext(Resource resource);

	/**
	 * @param applicationContext
	 */
	void processLifecylePreRenderActions(GuiEngineContext applicationContext);

	/**
	 * @param applicationContext
	 */
	void processLifecycleInitializedEvent(GuiEngineContext applicationContext);
	
	public void processLifecycleTransformWidgetsEvent(GuiEngineContext applicationContext);
	
	void processLifecylePostRestoreProcessing(GuiEngineContext applicationContext);

	void refreshMessages(GuiEngineContext context);
}
