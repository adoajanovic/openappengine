/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;


import org.springframework.util.Assert;
import org.w3c.dom.Document;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.ActionProcessor;
import com.openappengine.facade.core.executor.action.context.ActionContextFactory;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class SimpleActionDispatcher implements ActionDispatcher {
	
	private static ActionHandlerFactory factory;
	
	private ELContext elContext;

	private static ActionContextFactory actionContextFactory;
	
	private ExternalContext externalContext;
	
	private MessageContext messageContext;
	
	public SimpleActionDispatcher() {
	}

	static {
		Callback<ActionHandlerFactory> actionHandlerFactoryInitializationCallback = new ActionHandlerFactoryInitializationCallback();
		factory = (ActionHandlerFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_HANDLER_FACTORY,
				actionHandlerFactoryInitializationCallback);
		
		Callback<ActionContextFactory> callback = new ActionContextFactoryInitializationCallback();
		actionContextFactory = (ActionContextFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_CONTEXT_FACTORY, callback);
	}
	
	//TODO - Remove this method switch to executeAction
	@Override
	public Object execute(ActionRequest actionRequest) {
		Assert.notNull(actionRequest, "Action Request cannot be empty.");
		ActionHandler actionHandler = getActionHandlerFromFactory(actionRequest);
		ActionContext actionContext = actionContextFactory.createActionContext(actionHandler,elContext, externalContext,messageContext);
		Object result = null;//performActionProcessing(actionContext);
		return result;
	}
	
	@Override
	public ActionResponseXml executeAction(ActionRequestXml requestXml) {
		Document actionRequestXml = requestXml.getActionRequestXmlDocument();
		String actionName = UtilXml.readElementAttribute(actionRequestXml.getDocumentElement(), "action-name");
		ActionHandler actionHandler = getActionHandler(actionName);
		ActionContext actionContext = actionContextFactory.createActionContext(actionHandler,elContext, externalContext,messageContext);
		
		actionHandler.setActionContext(actionContext);
		ActionResponseXml responseXml = actionHandler.execute(requestXml);
		return responseXml;
	}

	
	/**
 	 *	Get ActionHandler from the Input Action Name.
	 * @param actionRequest
	 */
	protected ActionHandler getActionHandlerFromFactory(ActionRequest actionRequest) {
		String actionName = actionRequest.getActionName();
		ActionHandler actionHandler = getActionHandler(actionName);
		return actionHandler;
	}

	/**
	 * @param actionRequest
	 * @param actionName
	 * @return
	 */
	protected ActionHandler getActionHandler(String actionName) {
		ActionHandler actionHandler = factory.getActionHandler(actionName);
		Assert.notNull(actionHandler, "ActionHandler not found in the Factory.");
		return actionHandler;
	}

	protected ELContext getELContext() {
		return elContext;
	}

	public void setELContext(ELContext elContext) {
		this.elContext = elContext;
	}

	@Override
	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}
	
	protected ExternalContext getExternalContext() {
		return externalContext;
	}

	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}

}
