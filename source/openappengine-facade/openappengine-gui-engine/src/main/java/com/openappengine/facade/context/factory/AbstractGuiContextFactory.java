/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleProcessor;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public abstract class AbstractGuiContextFactory implements GuiContextFactory {

	protected static final Map<Resource, GuiApplicationContext> cachedGuiApplicationContexts = new ConcurrentHashMap<Resource, GuiApplicationContext>();
	
	private GuiDefinitionReader reader = new DefaultGuiDefinitionReader(this);
	
	private ContextConfiguration contextConfiguration;
	
	private LifecycleProcessor lifecycleProcessor;
	
	private Map<String,GuiComponent> unresolvedGuiComponents = new HashMap<String, GuiComponent>();
	
	protected GuiRootComponent createGuiRoot(Resource resource, GuiApplicationContext context) {
		GuiRootComponent uiRoot = reader.loadScreenDefinition(resource);
		context.setUIRoot(uiRoot);
		return uiRoot;
	}
	
	@Override
	public void registerScreenApplicationContext(Resource resource, GuiApplicationContext context) {
		cachedGuiApplicationContexts.put(resource, context);
	}

	public ContextConfiguration getContextConfiguration() {
		return contextConfiguration;
	}

	public void setContextConfiguration(ContextConfiguration contextConfiguration) {
		this.contextConfiguration = contextConfiguration;
	}

	@Override
	public boolean contains(Resource resource) {
		return cachedGuiApplicationContexts.containsKey(resource);
	}
	
	@Override
	public GuiApplicationContext getApplicationContext(Resource resource) {
		return cachedGuiApplicationContexts.get(resource);
	}

	protected LifecycleProcessor getLifecycleProcessor() {
		return lifecycleProcessor;
	}

	public void setLifecycleProcessor(LifecycleProcessor lifecycleProcessor) {
		this.lifecycleProcessor = lifecycleProcessor;
	}

	public Map<String,GuiComponent> getUnresolvedGuiComponents() {
		return unresolvedGuiComponents;
	}

	public void setUnresolvedGuiComponents(Map<String,GuiComponent> unresolvedGuiComponents) {
		this.unresolvedGuiComponents = unresolvedGuiComponents;
	}
}
