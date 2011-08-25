/**
 * 
 */
package com.ms.openapps.service;

import com.ms.openapps.entity.IGenericEntityDelegator;


/**
 * @author hrishi
 *
 */
public class ModelService {
	
	private String serviceId;
	
	private ModelServiceRunner modelServiceRunner;
	
	private IGenericEntityDelegator delegator;
	
	private boolean requiresDelegator = Boolean.TRUE;
	
	private boolean xmlService;
	
	public ModelService(String serviceId,
			ModelServiceRunner modelServiceRunner,
			IGenericEntityDelegator delegator, boolean requiresDelegator,
			boolean xmlService) {
		super();
		this.serviceId = serviceId;
		this.modelServiceRunner = modelServiceRunner;
		this.delegator = delegator;
		this.requiresDelegator = requiresDelegator;
		this.xmlService = xmlService;
	}

	/**
	 * @param serviceId
	 * @param modelServiceRunner
	 * @param delegator
	 * @param requiresDelegator
	 */
	public ModelService(String serviceId,
			ModelServiceRunner modelServiceRunner,
			IGenericEntityDelegator delegator, boolean requiresDelegator) {
		super();
		this.serviceId = serviceId;
		this.modelServiceRunner = modelServiceRunner;
		this.delegator = delegator;
		this.requiresDelegator = requiresDelegator;
	}

	/**
	 * @param serviceId
	 * @param modelServiceRunner
	 */
	public ModelService(String serviceId, ModelServiceRunner modelServiceRunner,IGenericEntityDelegator delegator) {
		super();
		this.serviceId = serviceId;
		this.modelServiceRunner = modelServiceRunner;
		this.delegator = delegator;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public void setModelServiceRunner(ModelServiceRunner modelServiceRunner) {
		this.modelServiceRunner = modelServiceRunner;
	}

	public ModelServiceRunner getModelServiceRunner() {
		return modelServiceRunner;
	}

	/**
	 * @param delegator the delegator to set
	 */
	public void setDelegator(IGenericEntityDelegator delegator) {
		this.delegator = delegator;
	}

	/**
	 * @return the delegator
	 */
	public IGenericEntityDelegator getDelegator() {
		return delegator;
	}

	/**
	 * @param requiresDelegator the requiresDelegator to set
	 */
	public void setRequiresDelegator(boolean requiresDelegator) {
		this.requiresDelegator = requiresDelegator;
	}

	/**
	 * @return the requiresDelegator
	 */
	public boolean isRequiresDelegator() {
		return requiresDelegator;
	}

	public void setXmlService(boolean xmlService) {
		this.xmlService = xmlService;
	}

	public boolean isXmlService() {
		return xmlService;
	}

}
