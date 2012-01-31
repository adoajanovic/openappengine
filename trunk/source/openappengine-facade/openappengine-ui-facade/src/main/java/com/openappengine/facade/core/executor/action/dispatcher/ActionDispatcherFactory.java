/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class ActionDispatcherFactory {
	
	public ActionDispatcher createActionDispatcher(ELContext elContext,ExternalContext externalContext,MessageContext messageContext) {
		ActionDispatcher actionDispatcher = new SimpleActionDispatcher();
		actionDispatcher.setExternalContext(externalContext);
		actionDispatcher.setELContext(elContext);
		actionDispatcher.setMessageContext(messageContext);
		return actionDispatcher;
	}

}
