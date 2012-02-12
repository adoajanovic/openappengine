/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import java.util.List;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.widget.Widget;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class ActionDispatcherFactory {
	
	public ActionDispatcher createActionDispatcher(ELContext elContext,ExternalContext externalContext,MessageContext messageContext,AbstractExecutableComponent exec) {
		return createActionDispatcher(elContext, externalContext,
				messageContext, exec, null);
	}

	public ActionDispatcher createActionDispatcher(ELContext elContext,
			ExternalContext externalContext, MessageContext messageContext,
			AbstractExecutableComponent exec, List<Widget> referencedWidgets) {
		ActionDispatcher actionDispatcher = new SimpleActionDispatcher();
		actionDispatcher.setExternalContext(externalContext);
		actionDispatcher.setELContext(elContext);
		actionDispatcher.setMessageContext(messageContext);
		actionDispatcher.setExecutable(exec);
		actionDispatcher.setActionReferencedWidgets(referencedWidgets);
		return actionDispatcher;
	}

}
