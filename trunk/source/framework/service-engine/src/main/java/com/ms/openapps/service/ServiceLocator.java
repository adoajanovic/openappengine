/**
 * 
 */
package com.ms.openapps.service;

/**
 * @author hrishi
 *
 */
public class ServiceLocator {
	
	/**
	 *  Fetch the Model Service from the ModelServiceFactory
	 * @param serviceName
	 * @return ModelService
	 * @throws ServiceNotFoundException
	 */
	public static ModelService getModelService(String serviceName) throws ServiceNotFoundException{
		ModelService modelService = ModelServiceFactory.getModelService(serviceName);
		return modelService;
	}
	
}
