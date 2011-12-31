/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class XmlScreenApplicationContextFactory implements ScreenApplicationContextFactory {
	
	protected static final Map<Resource, ScreenApplicationContext> cachedScreenApplicationContexts = new ConcurrentHashMap<Resource, ScreenApplicationContext>();

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
	public ScreenApplicationContext getScreenApplicationContext(Resource resource) {
		if(!contains(resource)) {
			reader.loadScreenDefinition(resource);
		}
		return cachedScreenApplicationContexts.get(resource);
	}

	@Override
	public void registerScreenApplicationContext(Resource resource, ScreenApplicationContext context) {
		cachedScreenApplicationContexts.put(resource, context);
	}

	public ContextConfiguration getContextConfiguration() {
		return contextConfiguration;
	}

	public void setContextConfiguration(ContextConfiguration contextConfiguration) {
		this.contextConfiguration = contextConfiguration;
	}

}
