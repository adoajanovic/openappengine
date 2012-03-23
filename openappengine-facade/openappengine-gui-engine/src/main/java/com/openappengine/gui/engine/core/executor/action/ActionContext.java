/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;


/**
 * @author hrishi
 * since Jan 3, 2012
 */
public interface ActionContext {
	
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
