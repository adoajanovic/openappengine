/**
 * 
 */
package com.openappengine.facade.core.executor.action.request;

import com.openappengine.facade.core.DataBeanWrappedActionRequest;


/**
 * Class that holds the Action specific requests for all the Actions.
 * 
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class DefaultActionRequest extends DataBeanWrappedActionRequest {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param actionName
	 * @param object
	 */
	public DefaultActionRequest(String actionName, Object object) {
		super(actionName, object);
	}

}
