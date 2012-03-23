/**
 * 
 */
package com.openappengine.service.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.service.Service;

/**
 * This represents a Model Service represented in the Service XML.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ModelService {
	
	private static final String PARAMETER_MODE_IN = "IN";

	private static final String PARAMETER_MODE_OUT = "OUT";

	private String name;
	
	private String description;
	
	private Class<? extends Service> serviceClass;
	
	private Method invokeMethod;
	
	private List<ModelServiceParameter> parameters = new ArrayList<ModelServiceParameter>();
	
	private Map<String,List<ModelServiceParameter>> parameterModeMap = new HashMap<String, List<ModelServiceParameter>>();

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
		if(this.parameters != null) {
			List<ModelServiceParameter> inParams = new ArrayList<ModelServiceParameter>();
			List<ModelServiceParameter> outParams = new ArrayList<ModelServiceParameter>();
			
			for (ModelServiceParameter parameter : parameters) {
				if(StringUtils.equals(PARAMETER_MODE_IN, parameter.getMode())) {
					inParams.add(parameter);
				} else if(StringUtils.equals(PARAMETER_MODE_OUT, parameter.getMode())) {
					outParams.add(parameter);
				} else if(StringUtils.equals("IN_OUT", parameter.getMode())) {
					inParams.add(parameter);
					outParams.add(parameter);
				}
			}
			
			parameterModeMap.put(PARAMETER_MODE_IN, inParams);
			parameterModeMap.put(PARAMETER_MODE_OUT, outParams);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	protected List<ModelServiceParameter> getParameters(String mode) {
		return parameterModeMap.get(mode);
	}
	
	public List<ModelServiceParameter> getInParams() {
		return getParameters(PARAMETER_MODE_IN);
	}
	
	public List<ModelServiceParameter> getOutParams() {
		return getParameters(PARAMETER_MODE_OUT);
	}

}
