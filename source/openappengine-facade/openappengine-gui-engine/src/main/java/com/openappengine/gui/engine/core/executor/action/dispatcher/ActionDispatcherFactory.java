/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.dispatcher;

import java.util.List;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.action.ActionDispatcher;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.widget.Widget;

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
