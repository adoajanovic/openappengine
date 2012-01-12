/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * This interfaces intends to decouple the GUI Component or Caller of the Actions
 * from the Actions themselves. This also achieves a very "light weight" ActionRequest 
 * object which is associated with the GUI Component rather than the Action themselves
 * which results into heavy weight objects.
 * 
 * Action Dispatcher has a dictionary/mapping of an Action Name -> Action Handler.
 * The Action Dispatcher fetches the Action Request from the Client and 
 * gets the correct ActionHandler for the Request. The parameters of the ActionRequest 
 * are mapped to the fields of the specific ActionHandler implementation.
 * 
 * The ActionDispatcher can also support async calls to the Actions which do not block
 * the Caller.
 * 
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public interface ActionDispatcher {

	/**
	 * Execute the encapsulated action.
	 * @param actionRequest
	 * @return Outcome of the action.
	 */
	Object execute(ActionRequest actionRequest);
	
	
	/**
	 * Pluggable EL Context for Variable Resolution and EL Expression Handling.
	 * @param elContext
	 */
	void setELContext(ELContext elContext);
	
	/**
	 * Set external context associated with this action handler.
	 * @param externalContext
	 */
	void setExternalContext(ExternalContext externalContext);
}
