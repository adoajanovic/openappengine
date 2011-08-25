/**
 * 
 */
package com.ms.openapps.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishi
 *
 */
public class ModelServiceFactory {
	
	private static Map<String, ModelService> serviceCache;
	
	static ModelService getModelService(String serviceName) {
		if(!serviceCache.containsKey(serviceName)) {
			throw new ServiceNotFoundException("Service Not Found " + serviceName);
		}
		return serviceCache.get(serviceName);
	}

	public static void addService(String serviceName,ModelService modelService) {
		if(serviceCache == null) {
			serviceCache = new HashMap<String, ModelService>();
		}
		serviceCache.put(serviceName, modelService);
	}
	/**
	 * @param serviceCache the serviceCache to set
	 */
	public static void setServiceCache(Map<String, ModelService> serviceCache) {
		ModelServiceFactory.serviceCache = serviceCache;
	}

}