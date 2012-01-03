/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import java.util.Map;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;

/**
 * Factory Class for creating the ActionContext. The ActionContext instance 
 * is used by the Action Processor to process the individual ActionHandlers.
 * 
 * The factory class is responsible for mapping the incoming action request parameters to the Action
 * Attributes/Properties. 
 * 
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public interface ActionContextFactory {
	
	/**
	 * Create an ActionContext based on the ActionHandler. Map the action parameters
	 * to the action fields/attributes.
	 * 
	 * @param actionHandler
	 * @param parameters
	 */
	ActionContext createActionContext(ActionHandler actionHandler, Map<String, Object> parameters, ELContext elContext); 

}
