/**
 * 
 */
package com.openappengine.facade.context.factory;

import com.openappengine.facade.core.context.GuiContextRestoreEventProcessor;
import com.openappengine.facade.core.context.LifecycleProcessor;
import com.openappengine.facade.core.context.event.ContextRestoreEvent;
import com.openappengine.facade.core.context.lifecycle.DefaultLifecycleProcessor;

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
		lifecycleProcessor.registerLifecycleEventProcessor(ContextRestoreEvent.class,new GuiContextRestoreEventProcessor());
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
