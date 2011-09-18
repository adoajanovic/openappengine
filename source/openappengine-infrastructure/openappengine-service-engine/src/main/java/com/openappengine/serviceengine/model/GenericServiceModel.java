/**
 * 
 */
package com.openappengine.serviceengine.model;

import java.io.Serializable;

import com.openappengine.serviceengine.ServiceReaderUtils;

/**
 * @author hrishi
 * 
 */
public class GenericServiceModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String serviceName;

	private String serviceClass;

	private String aggregateRoot;

	private ModelServiceRunner serviceRunner;

	public GenericServiceModel(String serviceName, String serviceClass,
			String aggregateRoot) {
		super();
		this.serviceName = serviceName;
		this.serviceClass = serviceClass;
		this.aggregateRoot = aggregateRoot;
		initServiceRunner(serviceClass);
	}

	private void initServiceRunner(String serviceClass) {
		Class<?> modelServiceReaderClass = ServiceReaderUtils
				.getRunnerClass(serviceClass);
		this.serviceRunner = new ModelServiceRunner(modelServiceReaderClass);
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAggregateRoot() {
		return aggregateRoot;
	}

	public void setAggregateRoot(String aggregateRoot) {
		this.aggregateRoot = aggregateRoot;
	}

	public ModelServiceRunner getServiceRunner() {
		return serviceRunner;
	}
}
