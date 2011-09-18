/**
 * 
 */
package com.openappengine.serviceengine.model;

import java.util.HashMap;
import java.util.Map;

import com.openappengine.serviceengine.ServiceNotFoundException;

/**
 * @author hrishi
 *
 */
public class ModelServiceFactory {
	
	private static Map<String, GenericServiceModel> serviceFactoryCache;
	
	public static GenericServiceModel getGenericService(String serviceName) {
		if(!serviceFactoryCache.containsKey(serviceName)) {
			throw new ServiceNotFoundException("Service Not Found " + serviceName);
		}
		return serviceFactoryCache.get(serviceName);
	}

	public static void addXmlServiceDefinition(String serviceName,GenericServiceModel genericServiceModel) {
		if(serviceFactoryCache == null) {
			serviceFactoryCache = new HashMap<String, GenericServiceModel>();
		}
		serviceFactoryCache.put(serviceName, genericServiceModel);
	}

}