/**
 * 
 */
package com.openappengine.gui.engine.core.context.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.context.LifecycleProcessor;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class DefaultLifecycleProcessor implements LifecycleProcessor {
	
	private Map<Class<?>, LifecycleEventProcessor<GuiEngineContext>> cachedLifecyleEventProcessor;
	
	public DefaultLifecycleProcessor() {
		cachedLifecyleEventProcessor = new HashMap<Class<?>, LifecycleEventProcessor<GuiEngineContext>>();
	}
	
	@Override
	public void processLifecycleEvent(ApplicationEvent<GuiEngineContext> e) {
		GuiEngineContext context = e.getSource();
		
		Class<?> clazz = e.getClass();
		LifecycleEventProcessor<GuiEngineContext> processor = cachedLifecyleEventProcessor.get(clazz);
		Assert.notNull(processor,"No Lifecycle processor registered for Event Class :" + clazz.getName());
		processor.onLifecycleEvent(e,context);
	}

	@Override
	public void registerLifecycleEventProcessor(Class<? extends ApplicationEvent<GuiEngineContext>> clazz,LifecycleEventProcessor<GuiEngineContext> lifecycleEventProcessor) {
		if(lifecycleEventProcessor ==null) {
			return;
		}
		cachedLifecyleEventProcessor.put(clazz, lifecycleEventProcessor);
	}

}
