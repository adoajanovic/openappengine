/**
 * 
 */
package com.openappengine.serviceengine.dispatcher;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.ServiceLocator;
import com.openappengine.serviceengine.engine.GenericServiceException;
import com.openappengine.serviceengine.engine.IGenericServiceEngine;
import com.openappengine.serviceengine.model.GenericServiceModel;

/**
 * @author hrishi
 *
 */
public class GenericServiceDispatcher implements IServiceDispatcher {
	
	private IGenericServiceEngine genericServiceEngine;

	/* (non-Javadoc)
	 * @see com.ms.openapps.service.dispatcher.IServiceDispatcher#runService(java.lang.String, java.util.Map)
	 */
	public Map<String, Object> runService(String name,
			Map<String,Object> params) throws GenericServiceException {
		GenericServiceModel modelService = ServiceLocator.getModelService(name);
		Map<String, Object> serviceResult = genericServiceEngine.runService(modelService, params);
		return serviceResult;
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.service.dispatcher.IServiceDispatcher#runService(java.lang.String, java.util.Map)
	 */
	public Document runXmlService(String name,
			Document params) throws GenericServiceException {
		GenericServiceModel modelService = ServiceLocator.getModelService(name);
		Document serviceResult = genericServiceEngine.runXmlService(modelService, params);
		return serviceResult;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.service.dispatcher.IServiceDispatcher#runServiceIgnore(java.lang.String, java.util.Map)
	 */
	public void runServiceIgnore(String name,
			Map<String,Object> params) throws GenericServiceException {
		GenericServiceModel modelService = ServiceLocator.getModelService(name);
		genericServiceEngine.runService(modelService, params);
	}
	
	
	public void runXmlServiceIgnoreResult(String name,
			Document params) throws GenericServiceException {
		GenericServiceModel modelService = ServiceLocator.getModelService(name);
		genericServiceEngine.runXmlServiceIgnoreResult(modelService, params);
	}

	/**
	 * @param genericServiceEngine the genericServiceEngine to set
	 */
	public void setGenericServiceEngine(IGenericServiceEngine genericServiceEngine) {
		this.genericServiceEngine = genericServiceEngine;
	}

	/**
	 * @return the genericServiceEngine
	 */
	public IGenericServiceEngine getGenericServiceEngine() {
		return genericServiceEngine;
	}

}
