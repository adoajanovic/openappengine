/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.Factory;
import org.apache.log4j.Logger;

/**
 * FactoryFinder is a class that holds the factories keyed by their names.
 * The factory returned can be used to create the specific instance tied to the 
 * factory implementation.
 * 
 * In case when a factory cannot be found in the finder; a Callback interface is provided
 * which can initialize the factory with the configuration`s that can be used later while
 * constructing/restoring the factory products.
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class FactoryFinder {
	
	private static final Map<String, Factory> cachedFactoryInstances = new ConcurrentHashMap<String, Factory>();
	
	private static final Logger LOG = Logger.getLogger(FactoryFinder.class);
	
	public static Factory getFactory(String name,Callback<?> callback) {
		Factory factory = null;
		if(cachedFactoryInstances.containsKey(name)) {
			return cachedFactoryInstances.get(name);
		}  
		
		if(callback != null) {
			factory = (Factory) callback.onCallback();
			cacheFactory(name, factory);
		}
		return factory;
	}
	
	public static final boolean containsFactory(String name) {
		return cachedFactoryInstances.containsKey(name);
	}

	/**
	 * @param name
	 * @param factory
	 */
	private static void cacheFactory(String name, Factory factory) {
		if(factory == null) {
			LOG.error("Factory : " + name + " was not initialized from the Callback.");
		}
		if(factory != null) {
			LOG.info("Factory : " + name + " was successfully initialized from the Callback. Saving the factory..");
			cachedFactoryInstances.put(name, factory);
		}
	}

}
