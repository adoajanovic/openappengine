/**
 * 
 */
package com.ms.openapps.service.reader;

import com.ms.openapps.service.context.ServiceContext;
import com.ms.openapps.service.context.ServiceContextDefinition;
import com.ms.openapps.util.UtilLogger;

/**
 * @author hrishi
 *
 */
public class XmlServiceDefinitionReader {

	private ServiceContextDefinition serviceContextDefinition;
	
	private UtilLogger logger = new UtilLogger(getClass());
	
	/**
	 * 	Init Method Reads Xml Services for each of the Service
	 */
	public void loadModelServices() {
		ModelServiceReader modelServiceReader = ServiceContext.getModelServiceReader();
		logger.logInfo("Calling ModelServiceReader to load Services");
		modelServiceReader.loadModelServices();
	}
	
	/**
	 * @param serviceContextDefinition the serviceContextDefinition to set
	 */
	public void setServiceContextDefinition(ServiceContextDefinition serviceContextDefinition) {
		this.serviceContextDefinition = serviceContextDefinition;
	}

	/**
	 * @return the serviceContextDefinition
	 */
	public ServiceContextDefinition getServiceContextDefinition() {
		return serviceContextDefinition;
	}
}