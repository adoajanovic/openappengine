/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.ScreenDefinitionReader;
import com.openappengine.facade.core.XmlScreenDefinitionReader;
import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class XmlScreenApplicationContextFactory implements ScreenApplicationContextFactory {
	
	private Map<Resource, ScreenApplicationContext> cachedScreenApplicationContexts = new ConcurrentHashMap<Resource, ScreenApplicationContext>();

	private ScreenDefinitionReader reader = new XmlScreenDefinitionReader(this);
	
	private ContextConfiguration contextConfiguration;
	
	public XmlScreenApplicationContextFactory() {
	}
	
	public XmlScreenApplicationContextFactory(ContextConfiguration contextConfiguration) {
		super();
		this.contextConfiguration = contextConfiguration;
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

	@Override
	public ScreenApplicationContext create() {
		if(contextConfiguration == null) {
			contextConfiguration = new DefaultContextConfiguration();
		}
		return null;
	}

}
