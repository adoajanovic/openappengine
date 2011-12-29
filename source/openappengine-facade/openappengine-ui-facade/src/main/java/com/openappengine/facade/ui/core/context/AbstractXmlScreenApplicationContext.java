/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import com.openappengine.facade.ui.core.ActionExecutor;
import com.openappengine.facade.ui.core.DefaultActionExecutor;
import com.openappengine.facade.ui.core.ExternalContext;
import com.openappengine.facade.ui.core.TransitionHandler;
import com.openappengine.facade.ui.core.UIRoot;
import com.openappengine.facade.ui.core.el.ExpressionEvaluator;
import com.openappengine.facade.ui.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.ui.core.renderer.ScreenRenderer;
import com.openappengine.facade.ui.core.variable.ScreenContextVariableResolver;
import com.openappengine.facade.ui.core.variable.VariableResolver;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public abstract class AbstractXmlScreenApplicationContext implements ScreenApplicationContext {
	
	private Resource resource;
	
	private ActionExecutor actionExecutor;
	
	private ExpressionEvaluator expressionEvaluator;
	
	private VariableResolver variableResolver;
	
	private UIRoot root;
	
	public AbstractXmlScreenApplicationContext(Resource resource) {
		Assert.notNull(resource,"Resource required for loading ScreenApplicationContext.");
		this.resource = resource;
		
		//Initialize Context Configuration.
		initConfiguration();
	}
	
	protected void initConfiguration() {
		actionExecutor = new DefaultActionExecutor();
		expressionEvaluator = new SimpleExpressionEvaluator(this);
		variableResolver = new ScreenContextVariableResolver(this);
	}
	
	@Override
	public Resource getResource() {
		return resource;
	}

	@Override
	public UIRoot getUIRoot() {
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

	/**
	 * Specific to the underlying environment.
	 */
	public abstract TransitionHandler getTransitionHandler();

	/**
	 * Specific to the underlying environment.
	 */
	public abstract ExternalContext getExternalContext();
	
	/**
	 * Specific to the underlying environment.
	 */
	public abstract ScreenRenderer getScreenRenderer();

}