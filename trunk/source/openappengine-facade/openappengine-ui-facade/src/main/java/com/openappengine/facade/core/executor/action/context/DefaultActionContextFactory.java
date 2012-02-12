/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.resolve.ELContextVariableResolver;

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
