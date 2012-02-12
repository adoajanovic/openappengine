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

	private ExternalContext externalContext;
	
	private MessageContext messageContext;
	
	public AbstractActionContext(ExternalContext externalContext,ELContext elContext) {
		super();
		this.elContext = elContext;
		this.externalContext = externalContext;
	}

	/**
	 * @param externalContext
	 * @param elContext
	 * @param actionHandler
	 * @param messageContext
	 */
	public AbstractActionContext(ExternalContext externalContext,
			ELContext elContext,
			MessageContext messageContext) {
		this(externalContext, elContext);
		this.setMessageContext(messageContext);
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
