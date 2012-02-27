/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.dispatcher;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.context.factory.Callback;
import com.openappengine.gui.engine.context.factory.FactoryConstants;
import com.openappengine.gui.engine.context.factory.FactoryFinder;
import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.action.xml.ActionParamsXml;
import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.action.xml.EntityActionRequestXml;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.action.ActionContext;
import com.openappengine.gui.engine.core.executor.action.ActionDispatcher;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;
import com.openappengine.gui.engine.core.executor.action.ActionHandlerFactory;
import com.openappengine.gui.engine.core.executor.action.context.ActionContextFactory;
import com.openappengine.gui.engine.core.executor.annotations.Action;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.request.transformer.ExternalRequestParamsXml;
import com.openappengine.gui.engine.core.transformer.ActionParamsXmlTransformer;
import com.openappengine.gui.engine.core.transformer.DefaultActionParamsXmlTransformer;
import com.openappengine.gui.engine.core.transformer.ExternalRequestParamsTransformer;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class SimpleActionDispatcher implements ActionDispatcher {
	
	protected static final Logger logger = Logger.getLogger(ActionDispatcher.class);
	
	private static final ActionHandlerFactory factory;
		
	private static final ActionContextFactory actionContextFactory;
	
	private ELContext elContext;
	
	private ExternalContext externalContext;
	
	private MessageContext messageContext;
	
	private AbstractExecutableComponent executable;
	
	private ExternalRequestParamsTransformer transformer = new ExternalRequestParamsTransformer();
	
	private ActionParamsXmlTransformer actionRequestXmlTransformer = new DefaultActionParamsXmlTransformer();
	
	
	public SimpleActionDispatcher() {
	}

	static {
		Callback<ActionHandlerFactory> actionHandlerFactoryInitializationCallback = new ActionHandlerFactoryInitializationCallback();
		factory = (ActionHandlerFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_HANDLER_FACTORY,
				actionHandlerFactoryInitializationCallback);
		
		Callback<ActionContextFactory> callback = new ActionContextFactoryInitializationCallback();
		actionContextFactory = (ActionContextFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_CONTEXT_FACTORY, callback);
	}
	
	public ActionResponseXml execute() {
		ExternalRequestParamsXml externalRequestParamsXml = transformer.transform((HttpServletRequest) externalContext.getRequest());
		
		ActionParamsXml actionParamsXml = actionRequestXmlTransformer.transform(executable);
		
		Action action = AnnotationUtils.findAnnotation(executable.getClass(), Action.class);
		String actionName = action.actionName();
		
		ActionRequestXml requestXml = new EntityActionRequestXml(externalRequestParamsXml,actionParamsXml,actionName);
		
		ActionContext actionContext = doCreateActionContext();
		ActionHandler actionHandler = getActionHandler(requestXml,actionContext);
		
		if(!actionHandler.supportsActionRequestXml(requestXml)) {
			throw new IllegalArgumentException("ActionRequest "
					+ requestXml.getClass() + "not supported by ActionHandler:"
					+ actionHandler.getClass());
		}
		ActionResponseXml responseXml = actionHandler.execute(requestXml);
		
		String valueField = executable.getValueField();
		Document responseDocument = responseXml.getResponseDocument();
		elContext.registerELContextVariable(valueField, responseDocument);
		
		return responseXml;
	}
	
	/**
	 * @param actionRequestXml
	 * @param actionContext
	 * @return
	 */
	private ActionHandler<?> getActionHandler(ActionRequestXml actionRequestXml,
			ActionContext actionContext) {
		String actionName = actionRequestXml.getActionName();
		ActionHandler<?> actionHandler = getActionHandler(actionName);
		actionHandler.setActionContext(actionContext);
		return actionHandler;
	}

	/**
	 * @return
	 */
	private ActionContext doCreateActionContext() {
		ActionContext actionContext = actionContextFactory.createActionContext(elContext,externalContext, messageContext);
		return actionContext;
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

	protected MessageContext getMessageContext() {
		return messageContext;
	}
	
	@Override
	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}

	@Override
	public void setExecutable(AbstractExecutableComponent exec) {
		Assert.notNull(exec,"Executable found null...!");
		this.executable = exec;
	}
}
