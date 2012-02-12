/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.Resolver;
import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.component.ui.message.ResourceBundleMessageContext;
import com.openappengine.gui.engine.core.el.DefaultJexlContext;
import com.openappengine.gui.engine.core.el.ExpressionEvaluator;
import com.openappengine.gui.engine.core.el.SimpleExpressionEvaluator;
import com.openappengine.gui.engine.core.executor.ActionExecutor;
import com.openappengine.gui.engine.core.executor.DefaultActionExecutor;
import com.openappengine.gui.engine.core.resolve.ELContextVariableResolver;
import com.openappengine.gui.engine.core.variable.Variable;

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