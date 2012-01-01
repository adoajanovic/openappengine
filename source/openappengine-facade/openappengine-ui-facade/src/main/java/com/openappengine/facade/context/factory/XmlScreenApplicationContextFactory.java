/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.WebGuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class XmlScreenApplicationContextFactory implements ScreenApplicationContextFactory {
	
	protected static final Map<Resource, GuiApplicationContext> cachedScreenApplicationContexts = new ConcurrentHashMap<Resource, GuiApplicationContext>();

	private ScreenDefinitionReader reader = new XmlScreenDefinitionReader(this);
	
	private ContextConfiguration contextConfiguration;
	
	public XmlScreenApplicationContextFactory() {
	}
	
	public XmlScreenApplicationContextFactory(ContextConfiguration contextConfiguration) {
		super();
		this.setContextConfiguration(contextConfiguration);
	}

	@Override
	public boolean contains(Resource resource) {
		return cachedScreenApplicationContexts.containsKey(resource);
	}

	@Override
	public GuiApplicationContext getScreenApplicationContext(Resource resource) {
		if(!contains(resource)) {
			WebGuiApplicationContext context = new WebGuiApplicationContext();
			
			GuiRootComponent uiRoot = reader.loadScreenDefinition(resource);
			uiRoot.setContext(context);
		}
		return cachedScreenApplicationContexts.get(resource);
	}

	@Override
	public void registerScreenApplicationContext(Resource resource, GuiApplicationContext context) {
		cachedScreenApplicationContexts.put(resource, context);
	}

	public ContextConfiguration getContextConfiguration() {
		return contextConfiguration;
	}

	public void setContextConfiguration(ContextConfiguration contextConfiguration) {
		this.contextConfiguration = contextConfiguration;
	}

}
