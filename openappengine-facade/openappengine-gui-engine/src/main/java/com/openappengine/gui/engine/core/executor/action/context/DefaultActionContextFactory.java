/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.context;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.action.ActionContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.resolve.ELContextVariableResolver;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContextFactory implements ActionContextFactory {
	
	private ELContextVariableResolver elContextVariableResolver;

	@Override
	public ActionContext createActionContext(ELContext elContext,ExternalContext externalContext,MessageContext messageContext) {
		ActionContext context = new DefaultActionContext(externalContext,elContext,messageContext);
		elContextVariableResolver = new ELContextVariableResolver(elContext);
		return context;
	}

	public ELContextVariableResolver getElContextVariableResolver() {
		return elContextVariableResolver;
	}

	public void setElContextVariableResolver(ELContextVariableResolver elContextVariableResolver) {
		this.elContextVariableResolver = elContextVariableResolver;
	}
}
