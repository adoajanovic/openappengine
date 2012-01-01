/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.TransitionHandler;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.executor.DefaultActionExecutor;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.variable.ScreenContextVariableResolver;
import com.openappengine.facade.core.variable.VariableResolver;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public abstract class AbstractGuiApplicationContext implements GuiApplicationContext {
	
	private ActionExecutor actionExecutor;
	
	private ExpressionEvaluator expressionEvaluator;
	
	private VariableResolver variableResolver;
	
	private GuiRootComponent root;
	
	public AbstractGuiApplicationContext() {
		//Initialize Context XmlScreenConfiguration.
		initConfiguration();
	}
	
	protected void initConfiguration() {
		actionExecutor = new DefaultActionExecutor();
		expressionEvaluator = new SimpleExpressionEvaluator(this);
		variableResolver = new ScreenContextVariableResolver(this);
	}
	
	@Override
	public GuiRootComponent getUIRoot() {
		return getRoot();
	}

	@Override
	public ExpressionEvaluator getExpressionEvaluator() {
		return expressionEvaluator;
	}

	@Override
	public VariableResolver getVariableResolver() {
		return variableResolver;
	}

	@Override
	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}
	
	@Override
	public abstract TransitionHandler getTransitionHandler();

	@Override
	public abstract ScreenRenderer getScreenRenderer();

	public GuiRootComponent getRoot() {
		return root;
	}

	protected void setRoot(GuiRootComponent root) {
		this.root = root;
	}

}