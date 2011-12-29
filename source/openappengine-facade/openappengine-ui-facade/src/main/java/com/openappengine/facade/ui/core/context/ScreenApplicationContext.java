/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import org.springframework.core.io.Resource;

import com.openappengine.facade.ui.core.ActionExecutor;
import com.openappengine.facade.ui.core.ExternalContext;
import com.openappengine.facade.ui.core.TransitionHandler;
import com.openappengine.facade.ui.core.UIRoot;
import com.openappengine.facade.ui.core.el.ExpressionEvaluator;
import com.openappengine.facade.ui.core.renderer.ScreenRenderer;
import com.openappengine.facade.ui.core.variable.VariableResolver;

/**
 * The Screen Application Context holds all the infrastructure dependencies related
 * to the Screen Reading,Rendering and Action Handling.  
 * 
 * @author hrishi
 * since Dec 29, 2011
 */
public interface ScreenApplicationContext {
	
	/**
	 * Get the Resource from which the current Screen was loaded.
	 * @return
	 */
	Resource getResource();
	
	/**
	 * Get The UIRoot of this context.
	 * @return
	 */
	UIRoot getUIRoot();
	
	/**
	 * Get the Expression Evaluator  
	 * @return
	 */
	ExpressionEvaluator getExpressionEvaluator();
	
	/**
	 * Get the Variable Resolver for this context.
	 * @return
	 */
	VariableResolver getVariableResolver();
	
	/**
	 * Get the ScreenRenderer for rendering the Xml Screen.
	 * @return
	 */
	ScreenRenderer getScreenRenderer();

	/**
	 * Get the ActionExecutor to execute any actions.
	 * @return
	 */
	ActionExecutor getActionExecutor();
	
	/**
	 * Get the TransitionHandler for the context.
	 * @return
	 */
	TransitionHandler getTransitionHandler();
	
	/**
	 * Get External Context.
	 * @return
	 */
	ExternalContext getExternalContext();
}
