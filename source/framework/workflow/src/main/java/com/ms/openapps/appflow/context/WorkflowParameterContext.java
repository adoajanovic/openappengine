/**
 * 	Represents the Flow Parameters used for input and output.
 */
package com.ms.openapps.appflow.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishi
 *
 */
public class WorkflowParameterContext {
	
	private Map<String, Object> flowParameters;
	
	/**
	 *  Add New Flow Parameter to the Context
	 * @param key
	 * @param value
	 */
	public void addFlowParameter(String key,Object value) {
		if(this.flowParameters == null) {
			flowParameters = new HashMap<String, Object>();
		}
		flowParameters.put(key, value);
	}
	
	/**
	 * @param flowParameters the flowParameters to set
	 */
	public void setFlowParameters(Map<String, Object> flowParameters) {
		this.flowParameters = flowParameters;
	}

	/**
	 * @return the flowParameters
	 */
	public Map<String, Object> getFlowParameters() {
		return flowParameters;
	}

}
