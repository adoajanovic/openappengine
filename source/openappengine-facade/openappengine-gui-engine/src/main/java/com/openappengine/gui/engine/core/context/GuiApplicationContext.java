/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import java.util.List;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.Resolver;
import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.el.ExpressionEvaluator;
import com.openappengine.gui.engine.core.executor.ActionExecutor;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.renderer.ScreenRenderer;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

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
	
	Document getScreenXmlDocument();
	
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
	Resolver getVariableResolver();
	
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
	
	List<Widget> getReferencedWidgets(String valueRef);
	
	void addValueReferencedWidget(String valueRef, Widget widget);
}