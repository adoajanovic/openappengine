/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public abstract class AbstractActionContext implements ActionContext {
	
	private ELContext elContext;

	private ActionHandler actionHandler;
	
	public AbstractActionContext(ELContext elContext, ActionHandler actionHandler) {
		super();
		this.elContext = elContext;
		this.actionHandler = actionHandler;
	}

	@Override
	public ActionHandler getActionHandler() {
		return actionHandler;
	}

	@Override
	public ELContext getELContext() {
		return elContext;
	}

	public void setELContext(ELContext elContext) {
		this.elContext = elContext;
	}

	public void setActionHandler(ActionHandler actionHandler) {
		this.actionHandler = actionHandler;
	}

}
