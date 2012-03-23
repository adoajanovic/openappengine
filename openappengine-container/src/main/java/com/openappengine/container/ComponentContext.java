/**
 * 
 */
package com.openappengine.container;

import java.util.Map;

import javolution.util.FastMap;

/**
 * @author hrishi
 *
 */
public class ComponentContext {
	
	/* Component ClassLoaders*/
	private static Map<String,ClassLoader> componentClassLoaderCache = new FastMap<String, ClassLoader>();


	public static ClassLoader getLifecycleClassLoader() {
		return ComponentContext.class.getClassLoader();
	}
	
	/**
	 *  Get the ClassLoader for the Component. If not found or null, returns the ClassLoader of the current Class.
	 * @param componentName
	 * @return ClassLoader
	 */
	public static ClassLoader getComponentClassLoader(String componentName) {
		if(componentClassLoaderCache.isEmpty() || !componentClassLoaderCache.containsKey(componentName)) {
			return ComponentContext.class.getClassLoader();
		}
		return componentClassLoaderCache.get(componentName);
	}
	
	/**
	 * @param componentClassLoaderCache the componentClassLoaderCache to set
	 */
	public static void setComponentClassLoaderCache(
			Map<String,ClassLoader> componentClassLoaderCache) {
		ComponentContext.componentClassLoaderCache = componentClassLoaderCache;
	}

	/**
	 * @return the componentClassLoaderCache
	 */
	public static Map<String,ClassLoader> getComponentClassLoaderCache() {
		return componentClassLoaderCache;
	} 

	
	
}
