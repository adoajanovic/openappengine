/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;

import com.openappengine.facade.ui.core.ScreenDefinitionReader;
import com.openappengine.facade.ui.core.XmlScreenDefinitionReader;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class XmlScreenApplicationContextFactory implements ScreenApplicationContextFactory {
	
	private Map<Resource, ScreenApplicationContext> cachedScreenApplicationContexts = new ConcurrentHashMap<Resource, ScreenApplicationContext>();

	private ScreenDefinitionReader reader = new XmlScreenDefinitionReader(this);
	
	@Override
	public boolean contains(Resource resource) {
		return cachedScreenApplicationContexts.containsKey(resource);
	}

	@Override
	public ScreenApplicationContext getScreenApplicationContext(Resource resource) {
		//TODO - Call the contains to check if this is present in the factory.
		//If not present use the reader to load the Screen Definition and register it with the factory for the next call.
		//Return the Screen Definition loaded.
		return cachedScreenApplicationContexts.get(resource);
	}

	@Override
	public void registerScreenApplicationContext(Resource resource, ScreenApplicationContext context) {
		cachedScreenApplicationContexts.put(resource, context);
	}

}
