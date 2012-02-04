/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.ext.ExternalContext;


/**
 * @author hrishi
 * since Jan 3, 2012
 */
public interface ActionContext {
	
	/**
	 * Get ActionHandler for this Action.
	 * @return ActionHandler
	 */
	ActionHandler getActionHandler();
	
	/**
	 * Get EL Context to resolve EL expression if any plugged into the ActionHandler fields/variables.
	 * @return
	 */
	ELContext getELContext();

	/**
	 * @return
	 */
	ExternalContext getExternalContext();
	
	/**
	 * @return
	 */
	MessageContext getMessageContext();
}
