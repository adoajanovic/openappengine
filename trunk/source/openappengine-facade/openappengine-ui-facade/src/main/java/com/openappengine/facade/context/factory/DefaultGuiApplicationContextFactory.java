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
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class DefaultGuiApplicationContextFactory implements GuiContextFactory {
	
	protected static final Map<Resource, GuiApplicationContext> cachedGuiApplicationContexts = new ConcurrentHashMap<Resource, GuiApplicationContext>();

	private GuiDefinitionReader reader = new DefaultGuiDefinitionReader(this);
	
	private ContextConfiguration contextConfiguration;
	
	public DefaultGuiApplicationContextFactory() {
	}
	
	public DefaultGuiApplicationContextFactory(ContextConfiguration contextConfiguration) {
		super();
		this.setContextConfiguration(contextConfiguration);
	}

	@Override
	public boolean contains(Resource resource) {
		return cachedGuiApplicationContexts.containsKey(resource);
	}

	@Override
	public GuiApplicationContext createGuiApplicationContext(Resource resource,ExternalContext externalContext) {
		if(!contains(resource)) {
			WebGuiApplicationContext context = new WebGuiApplicationContext();
			GuiRootComponent uiRoot = reader.loadScreenDefinition(resource);
			uiRoot.setContext(context);
			if(externalContext != null) {
				Map<String, Object> requestParameters = externalContext.getRequestParameters();
				context.processPreActions();
			}
		}
		return cachedGuiApplicationContexts.get(resource);
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

}
