/**
 * 
 */
package com.openappengine.serviceengine;

import com.openappengine.serviceengine.model.GenericServiceModel;
import com.openappengine.serviceengine.model.ModelServiceFactory;

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
	public static GenericServiceModel getModelService(String serviceName) throws ServiceNotFoundException{
		GenericServiceModel modelService = ModelServiceFactory.getGenericService(serviceName);
		return modelService;
	}
}
