/**
 * 
 */
package com.openappengine.service.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.service.Service;

/**
 * This represents a Model Service represented in the Service XML.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ModelService {
	
	private String name;
	
	private String description;
	
	private Class<? extends Service> serviceClass;
	
	private Method invokeMethod;
	
	private List<ModelServiceParameter> parameters = new ArrayList<ModelServiceParameter>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<? extends Service> getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(Class<? extends Service> serviceClass) {
		this.serviceClass = serviceClass;
	}

	public Method getInvokeMethod() {
		return invokeMethod;
	}

	public void setInvokeMethod(Method invokeMethod) {
		this.invokeMethod = invokeMethod;
	}

	public List<ModelServiceParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ModelServiceParameter> parameters) {
		this.parameters = parameters;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
