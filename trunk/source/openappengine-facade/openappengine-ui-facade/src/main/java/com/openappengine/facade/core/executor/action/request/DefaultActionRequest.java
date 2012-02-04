/**
 * 
 */
package com.openappengine.facade.core.executor.action.request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.facade.core.DataBeanWrappedActionRequest;

/**
 * Class that holds the Action specific requests for all the Actions.
 * 
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class DefaultActionRequest extends DataBeanWrappedActionRequest {

	private static final long serialVersionUID = 1L;
	
	private String actionName;
	
	private Map<String,Object> actionParameters = new ConcurrentHashMap<String, Object>();
	
	/**
	 * @param actionName
	 * @param object
	 */
	public DefaultActionRequest(String actionName, Object object) {
		super(actionName, object);
	}

}
