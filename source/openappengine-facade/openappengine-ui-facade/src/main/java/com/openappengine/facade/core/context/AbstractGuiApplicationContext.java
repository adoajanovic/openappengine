/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.el.DefaultJexlContext;
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.executor.DefaultActionExecutor;
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
	
	private ELContext elContext;
	
	private GuiRootComponent root;
	
	public AbstractGuiApplicationContext() {
		initializeStrategies();
	}
	
	//Initialize Context XmlScreenConfiguration.
	protected void initializeStrategies() {
		actionExecutor = new DefaultActionExecutor();
		variableResolver = new ScreenContextVariableResolver(this);
		elContext = new DefaultJexlContext();
		initializeExpressionEvaluator();
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
	public VariableResolver getVariableResolver() {
		return variableResolver;
	}

	@Override
	public ActionExecutor getActionExecutor() {
		return actionExecutor;
	}
	
	@Override
	public abstract ScreenRenderer getScreenRenderer();
	
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

}