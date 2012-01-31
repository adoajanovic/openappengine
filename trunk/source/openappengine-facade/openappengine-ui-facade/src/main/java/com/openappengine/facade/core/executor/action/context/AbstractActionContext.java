/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
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
	
	private MessageContext messageContext;
	
	public AbstractActionContext(ExternalContext externalContext,ELContext elContext, ActionHandler actionHandler) {
		super();
		this.elContext = elContext;
		this.actionHandler = actionHandler;
		this.externalContext = externalContext;
	}

	/**
	 * @param externalContext
	 * @param elContext
	 * @param actionHandler
	 * @param messageContext
	 */
	public AbstractActionContext(ExternalContext externalContext,ELContext elContext, ActionHandler actionHandler,MessageContext messageContext) {
		this(externalContext, elContext, actionHandler);
		this.setMessageContext(messageContext);
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

	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}
}
