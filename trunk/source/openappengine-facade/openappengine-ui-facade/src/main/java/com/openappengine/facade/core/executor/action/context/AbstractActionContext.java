/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public abstract class AbstractActionContext implements ActionContext {
	
	private ELContext elContext;

	private ActionHandler actionHandler;
	
	private ExternalContext externalContext;
	
	public AbstractActionContext(ExternalContext externalContext,ELContext elContext, ActionHandler actionHandler) {
		super();
		this.elContext = elContext;
		this.actionHandler = actionHandler;
		this.externalContext = externalContext;
	}

	@Override
	public ActionHandler getActionHandler() {
		return actionHandler;
	}

	@Override
	public ELContext getELContext() {
		return elContext;
	}

	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}
}
