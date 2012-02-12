/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.Resolver;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.component.ui.message.ResourceBundleMessageContext;
import com.openappengine.facade.core.el.DefaultJexlContext;
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.executor.DefaultActionExecutor;
import com.openappengine.facade.core.resolve.ELContextVariableResolver;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public abstract class AbstractGuiApplicationContext implements GuiApplicationContext {
	
	private ActionExecutor actionExecutor;
	
	private ExpressionEvaluator expressionEvaluator;
	
	private Resolver variableResolver;
	
	private ELContext elContext;
	
	private GuiRootComponent root;
	
	private MessageContext messageContext;
	
	public AbstractGuiApplicationContext() {
		initializeStrategies();
	}
	
	//Initialize Context XmlScreenConfiguration.
	protected void initializeStrategies() {
		actionExecutor = new DefaultActionExecutor();
		
		elContext = new DefaultJexlContext();
		
		variableResolver = new ELContextVariableResolver(elContext);
		
		initializeExpressionEvaluator();
		
		messageContext = new ResourceBundleMessageContext();
	}

	/**
	 * 
	 */
	private void initializeExpressionEvaluator() {
		expressionEvaluator = new SimpleExpressionEvaluator();
		expressionEvaluator.setELContext(elContext);
	}
	
	@Override
	public GuiRootComponent getUIRoot() {
		return root;
	}

	@Override
	public ExpressionEvaluator getExpressionEvaluator() {
		return expressionEvaluator;
	}

	@Override
	public Resolver getVariableResolver() {
		return variableResolver;
	}

	@Override
	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}
	
	@Override
	public ELContext getELContext() {
		return elContext;
	}

	public void setUIRoot(GuiRootComponent root) {
		this.root = root;
	}

	@Override
	public void registerVariable(String name, Object value) {
		if(root != null) {
			Variable var = new Variable();
			var.setName(name);
			var.setValue(value);
			root.getScreenVariables().put(name, var);
		}
		elContext.registerELContextVariable(name, value);
	}

	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}

}