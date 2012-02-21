/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.dispatcher;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.action.ActionDispatcher;
import com.openappengine.gui.engine.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class ActionDispatcherFactory {
	
	public ActionDispatcher createActionDispatcher(ELContext elContext,ExternalContext externalContext,MessageContext messageContext,AbstractExecutableComponent exec) {
		ActionDispatcher actionDispatcher = new SimpleActionDispatcher();
		actionDispatcher.setExternalContext(externalContext);
		actionDispatcher.setELContext(elContext);
		actionDispatcher.setMessageContext(messageContext);
		actionDispatcher.setExecutable(exec);
		return actionDispatcher;
	}

}
