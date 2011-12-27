/**
 * 
 */
package com.openappengine.facade.ui.core;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishikesh.joshi
 * @since Dec 27, 2011
 */
public class XmlScreenDefinitionFactory implements XmlScreenDefinitionRegistry {
	
	protected Map<String,Screen> screenDefinitionMap = new ConcurrentHashMap<String, Screen>();

	private XmlScreenDefinitionReader reader = new XmlScreenDefinitionReader(this);
	
	public XmlScreenDefinitionFactory(Resource resource) {
		Assert.notNull(resource, "Resource cannot be null for loading the Screen Definitions.");
		try {
			reader.readScreenDefinition(resource);
		} catch (IOException e) {
			throw new XmlScreenDefinitionException("Unable to instantiate screen from resouce " + resource.getFilename());
		}
	}
	
	// Implementations from XmlScreenDefinitionRegistry interface //
	@Override
	public void registerScreenDefinition(String screenName, Screen screen) {
		synchronized (screenDefinitionMap) {
			screenDefinitionMap.put(screenName, screen);
		}
	}

	@Override
	public boolean containsScreenDefinition(String screenName) {
		return screenDefinitionMap.containsKey(screenName);
	}

	@Override
	public Screen getScreenDefinition(String screenName) {
		return screenDefinitionMap.get(screenName);
	}

}
