/**
 * 
 */
package com.openappengine.facade.core.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.executor.ActionExecutor;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.variable.VariableResolver;
import com.openappengine.facade.fsm.TransitionEventListener;

/**
 * The Screen Application Context holds all the infrastructure dependencies related
 * to the Screen Reading,Rendering and ActionHandler Handling.  
 * 
 * @author hrishi
 * since Dec 29, 2011
 */
public interface GuiApplicationContext {
	
	/**
	 *  Restore Gui Component.
	 */
	public static final String RESTORE_GUI_COMPONENT = "RESTORE_GUI_COMPONENT";
	
	/**
	 *  Apply Parameters.
	 */
	public static final String APPLY_PARAMETERS = "APPLY_PARAMETERS";
	
	/**
	 * Get The UIRoot of this context.
	 * @return
	 */
	GuiRootComponent getUIRoot();
	
	/**
	 * Set the Root.
	 * @param root
	 */
	void setUIRoot(GuiRootComponent root);
	
	/**
	 * Get EL Context.
	 * @return
	 */
	ELContext getELContext();
	
	/**
	 * Register Variable.
	 * @param name
	 * @param value
	 */
	void registerVariable(String name,Object value);
	
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
	
	TransitionEventListener getTransitionEventListener();
	
	MessageContext getMessageContext();
	
	/**
	 * @return
	 */
	ExternalContext getExternalContext();
	
	/**
	 *  Overriden by SubClasses to Perform Post Initialization Process.
	 */
	void postRootConstruction();
	
	void setExternalContext(ExternalContext externalContext);
}