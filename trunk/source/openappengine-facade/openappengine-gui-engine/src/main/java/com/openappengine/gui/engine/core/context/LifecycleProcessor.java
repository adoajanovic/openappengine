/**
 * 
 */
package com.openappengine.gui.engine.core.context;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public interface LifecycleProcessor {

	/**
	 * Register a Lifecycle Event Processor.
	 * @param lifecycleEventProcessor
	 */
	public void registerLifecycleEventProcessor(Class<? extends ApplicationEvent<GuiEngineContext>> clazz,LifecycleEventProcessor<GuiEngineContext> lifecycleEventProcessor);
	
	/**
	 * Process Lifecycle Event.
	 * @param e
	 */
	void processLifecycleEvent(ApplicationEvent<GuiEngineContext> e);

}
