/**
 * 
 */
package com.openappengine.facade.core.executor.action.request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.ActionRequest;

/**
 * Class that holds the Action specific requests for all the Actions.
 * 
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class DefaultActionRequest implements ActionRequest {

	private static final long serialVersionUID = 1L;
	
	private String actionName;
	
	private Map<String,Object> actionParameters;
	
	public DefaultActionRequest(String actionName, Map<String, Object> actionParameters) {
		super();
		if(StringUtils.isEmpty(actionName)) {
			throw new IllegalArgumentException("ActionName cannot be empty for creating an Action Request Object.");
		}
		this.actionName = actionName;
		this.actionParameters = actionParameters;
	}
	
	public DefaultActionRequest(String actionName) {
		this(actionName,new ConcurrentHashMap<String, Object>());
	}

	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public Map<String, Object> getActionParameters() {
		return actionParameters;
	}

	@Override
	public void addActionParameters(Map<String, Object> params) {
		if(params == null) {
			return;
		}
		actionParameters.putAll(params);
	}

	@Override
	public void addActionParameter(String param, Object value) {
		if(StringUtils.isEmpty(param) || value == null) {
			return;
		}
			
		actionParameters.put(param, value);
	}

}
