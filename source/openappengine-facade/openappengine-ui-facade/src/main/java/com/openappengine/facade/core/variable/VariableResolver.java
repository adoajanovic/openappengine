/**
 * 
 */
package com.openappengine.facade.core.variable;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.GuiApplicationContextAware;

/**
 * Interface that resolve the value from the variable names.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface VariableResolver extends GuiApplicationContextAware {
	
	Object getValue(String name);
	
	void setGuiApplicationContext(GuiApplicationContext context);

}
