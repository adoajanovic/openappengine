/**
 * 
 */
package com.openappengine.facade.core.context.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;
import com.openappengine.facade.core.context.LifecycleProcessor;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class DefaultLifecycleProcessor implements LifecycleProcessor {
	
	private Map<Class<?>, LifecycleEventProcessor<GuiApplicationContext>> cachedLifecyleEventProcessor;
	
	public DefaultLifecycleProcessor() {
		cachedLifecyleEventProcessor = new HashMap<Class<?>, LifecycleEventProcessor<GuiApplicationContext>>();
	}
	
	@Override
	public void processLifecycleEvent(ApplicationEvent<GuiApplicationContext> e) {
		GuiApplicationContext context = e.getSource();
		
		Class<?> clazz = e.getClass();
		LifecycleEventProcessor<GuiApplicationContext> processor = cachedLifecyleEventProcessor.get(clazz);
		Assert.notNull(processor,"No Lifecycle processor registered for Event Class :" + clazz.getName());
		processor.onLifecycleEvent(e,context);
	}

	@Override
	public void registerLifecycleEventProcessor(Class<? extends ApplicationEvent<GuiApplicationContext>> clazz,LifecycleEventProcessor<GuiApplicationContext> lifecycleEventProcessor) {
		if(lifecycleEventProcessor ==null) {
			return;
		}
		cachedLifecyleEventProcessor.put(clazz, lifecycleEventProcessor);
	}

}
