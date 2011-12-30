/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.Factory;

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
	
	public static Factory getFactory(String name,Callback<?> callback) {
		Factory factory = cachedFactoryInstances.get(name);
		return factory;
	}

}
