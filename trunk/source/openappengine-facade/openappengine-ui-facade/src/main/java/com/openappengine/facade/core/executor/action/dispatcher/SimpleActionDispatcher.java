/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;


import org.springframework.util.Assert;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.ActionProcessor;
import com.openappengine.facade.core.executor.action.context.ActionContextFactory;
import com.openappengine.facade.core.executor.action.processor.DefaultActionProcessor;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class SimpleActionDispatcher implements ActionDispatcher {
	
	private static ActionHandlerFactory factory;
	
	//A Pluggable ELContext interface for variable resolution and expression evaluation.
	private ELContext elContext;

	private static ActionContextFactory actionContextFactory;
	
	private ExternalContext externalContext;
	
	public SimpleActionDispatcher() {
	}

	static {
		Callback<ActionHandlerFactory> actionHandlerFactoryInitializationCallback = new ActionHandlerFactoryInitializationCallback();
		factory = (ActionHandlerFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_HANDLER_FACTORY,
				actionHandlerFactoryInitializationCallback);
		
		Callback<ActionContextFactory> callback = new ActionContextFactoryInitializationCallback();
		actionContextFactory = (ActionContextFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_CONTEXT_FACTORY, callback);
	}
	
	@Override
	public Object execute(ActionRequest actionRequest) {
		Assert.notNull(actionRequest, "Action Request cannot be empty.");
		ActionHandler actionHandler = getActionHandlerFromFactory(actionRequest);
		
		ActionContext actionContext = actionContextFactory.createActionContext(actionHandler, actionRequest, elContext, externalContext);
		Object result = performActionProcessing(actionContext);
		return result;
	}

	/**
	 * @param actionContext
	 * @return
	 */
	protected Object performActionProcessing(ActionContext actionContext) {
		ActionProcessor actionProcessor = new DefaultActionProcessor();
		Object result = actionProcessor.performProcessing(actionContext);
		return result;
	}

	/**
 	 *	Get ActionHandler from the Input Action Name.
	 * @param actionRequest
	 */
	protected ActionHandler getActionHandlerFromFactory(ActionRequest actionRequest) {
		String actionName = actionRequest.getActionName();
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
}
