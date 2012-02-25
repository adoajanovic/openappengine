/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleProcessor;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public abstract class AbstractGuiContextFactory implements GuiContextFactory {

	protected static final Map<Resource, GuiEngineContext> cachedGuiApplicationContexts = new ConcurrentHashMap<Resource, GuiEngineContext>();
	
	private GuiDefinitionReader reader = new DefaultGuiDefinitionReader(this);
	
	private ContextConfiguration contextConfiguration;
	
	private LifecycleProcessor lifecycleProcessor;
	
	protected GuiRootComponent createGuiRoot(Resource resource, GuiEngineContext context) {
		GuiRootComponent uiRoot = reader.loadScreenDefinition(resource);
		context.setUIRoot(uiRoot);
		return uiRoot;
	}
	
	protected Document getScreenXmlDocument(Resource resource) {
		Document document = reader.getScreenXmlDocument(resource);
		return document;
	}
	
	@Override
	public void registerGuiEngineContext(Resource resource, GuiEngineContext context) {
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
	public GuiEngineContext getApplicationContext(Resource resource) {
		return cachedGuiApplicationContexts.get(resource);
	}

	protected LifecycleProcessor getLifecycleProcessor() {
		return lifecycleProcessor;
	}

	public void setLifecycleProcessor(LifecycleProcessor lifecycleProcessor) {
		this.lifecycleProcessor = lifecycleProcessor;
	}

}
