/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.ext.ExternalContext;

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
	ActionContext createActionContext(ActionHandler actionHandler, ActionRequest actionRequest, ELContext elContext,ExternalContext externalContext); 

}
