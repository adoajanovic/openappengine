package com.openappengine.facade.core.context.event.processor;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;

public class GuiContextInitializedEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		logger.info("Processing Context Initialized Event.");
		//TODO - Extend for addition.		
	}
}
