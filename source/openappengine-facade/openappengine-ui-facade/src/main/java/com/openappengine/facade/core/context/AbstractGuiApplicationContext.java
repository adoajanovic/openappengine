/**
 * 
 */
package com.openappengine.facade.core.context;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.TransitionHandler;
import com.openappengine.facade.core.component.executable.PreActionsComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.executor.DefaultActionExecutor;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.executor.action.dispatcher.SimpleActionDispatcher;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.variable.ScreenContextVariableResolver;
import com.openappengine.facade.core.variable.Variable;
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

	private ActionDispatcher actionDispatcher;
	
	public AbstractGuiApplicationContext() {
		//Initialize Context XmlScreenConfiguration.
		initConfiguration();
	}
	
	protected void initConfiguration() {
		actionExecutor = new DefaultActionExecutor();
		expressionEvaluator = new SimpleExpressionEvaluator();
		variableResolver = new ScreenContextVariableResolver(this);
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
	
	public void processPreActions() {
		Assert.notNull(getActionExecutor(),"ActionHandler Executor cannot be null.");
		
		if(root == null) {
			throw new IllegalStateException("GUI Component Root not initialized.");
		}
		
		//PreActions.
		if(root.isPreActionConfigured()) {
			PreActionsComponent preActions = root.getPreActions();
			ActionRequest actionRequest = preActions.getActionRequest();
			
			actionDispatcher = createActionDispatcher();
			
			Object actionOutput = actionDispatcher.execute(actionRequest);
			
			String valueField = preActions.getValueField();
			
			//If Value Field is provided by the Action Save the outcome to Context Variables.
			if(!StringUtils.isEmpty(valueField)) {
				Variable variable = new Variable();
				variable.setName(valueField);
				variable.setValue(actionOutput);
				getUIRoot().getScreenVariables().put(valueField, variable);
			}
		}
	}

	/**
	 * @return
	 */
	protected ActionDispatcher createActionDispatcher() {
		ActionDispatcher actionDispatcher = new SimpleActionDispatcher();
		actionDispatcher.setELContext(getELContext());
		return actionDispatcher;
	}
	
	@Override
	public ELContext getELContext() {
		return null;
	}

	public void setUIRoot(GuiRootComponent root) {
		this.root = root;
	}

}