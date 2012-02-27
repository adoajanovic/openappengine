/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.Resolver;
import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.el.ExpressionEvaluator;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.variable.Variable;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

/**
 * The Screen Application Context holds all the infrastructure dependencies related
 * to the Screen Reading,Rendering and ActionHandler Handling.  
 * 
 * @author hrishi
 * since Dec 29, 2011
 */
public interface GuiEngineContext {
	
	Document getScreenXmlDocument();
	
	
	PreRenderActions getPreRenderActions();
	
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
	
	Map<String, Variable> getScreenVariables();
	
	Object getWidget(String id);
	
	void addWidget(String id,Document doc);
	
	List<String> getWidgets();
}