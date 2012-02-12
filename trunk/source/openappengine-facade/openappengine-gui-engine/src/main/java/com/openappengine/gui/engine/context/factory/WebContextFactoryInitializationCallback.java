/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import com.openappengine.gui.engine.core.context.LifecycleProcessor;
import com.openappengine.gui.engine.core.context.event.ContextInitializedEvent;
import com.openappengine.gui.engine.core.context.event.ContextPostRestoreEvent;
import com.openappengine.gui.engine.core.context.event.ExecutePreRenderActionsEvent;
import com.openappengine.gui.engine.core.context.event.GuiContextMessageRefreshEvent;
import com.openappengine.gui.engine.core.context.event.processor.ExecutePreRenderActionsEventProcessor;
import com.openappengine.gui.engine.core.context.event.processor.GuiContextInitializedEventProcessor;
import com.openappengine.gui.engine.core.context.event.processor.GuiContextPostRestoreEventProcessor;
import com.openappengine.gui.engine.core.context.event.processor.UpdateMessageEventProcessor;
import com.openappengine.gui.engine.core.context.lifecycle.DefaultLifecycleProcessor;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class WebContextFactoryInitializationCallback extends ContextFactoryInitializationCallback {
	
	private ContextConfiguration contextConfiguration;
	
	public WebContextFactoryInitializationCallback() {
	}

	public WebContextFactoryInitializationCallback(ContextConfiguration contextConfiguration) {
		super();
		this.contextConfiguration = contextConfiguration;
	}

	@Override
	protected GuiContextFactory createFactory() {
		createDefaultContextConfigurationIfNull();
		GuiWebApplicationContextFactory factory = new GuiWebApplicationContextFactory(getContextConfiguration());
		LifecycleProcessor lifecycleProcessor = createLifecycleListener();
		factory.setLifecycleProcessor(lifecycleProcessor);
		return factory;
	}

	/**
	 * @return
	 */
	protected LifecycleProcessor createLifecycleListener() {
		DefaultLifecycleProcessor lifecycleProcessor = new DefaultLifecycleProcessor();
		registerApplicationLifecycleEventProcessors(lifecycleProcessor);
		return lifecycleProcessor;
	}

	/**
	 * @param lifecycleProcessor
	 */
	protected void registerApplicationLifecycleEventProcessors(DefaultLifecycleProcessor lifecycleProcessor) {
		lifecycleProcessor.registerLifecycleEventProcessor(ContextPostRestoreEvent.class,new GuiContextPostRestoreEventProcessor());
		lifecycleProcessor.registerLifecycleEventProcessor(ExecutePreRenderActionsEvent.class,new ExecutePreRenderActionsEventProcessor());
		lifecycleProcessor.registerLifecycleEventProcessor(ContextInitializedEvent.class,new GuiContextInitializedEventProcessor());
		lifecycleProcessor.registerLifecycleEventProcessor(GuiContextMessageRefreshEvent.class,new UpdateMessageEventProcessor());
		//TODO - Add Other Event Processors.
	}

	protected void createDefaultContextConfigurationIfNull() {
		if(contextConfiguration == null) {
			contextConfiguration = new DefaultContextConfiguration();
		}
	}

	public ContextConfiguration getContextConfiguration() {
		return contextConfiguration;
	}

	public void setContextConfiguration(ContextConfiguration contextConfiguration) {
		this.contextConfiguration = contextConfiguration;
	}

}
