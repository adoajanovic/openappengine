/**
 * 
 */
package com.openappengine.gui.engine.core.variable;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.GuiApplicationContextAware;

/**
 * Interface that resolve the value from the variable names.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface VariableResolver extends GuiApplicationContextAware {
	
	Object getValue(String name);
	
	void setGuiApplicationContext(GuiEngineContext context);

}
