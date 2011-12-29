/**
 * 
 */
package com.openappengine.facade.ui.core.variable;

import com.openappengine.facade.ui.core.context.ScreenApplicationContext;
import com.openappengine.facade.ui.core.context.ScreenApplicationContextAware;

/**
 * Interface that resolve the value from the variable names.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface VariableResolver extends ScreenApplicationContextAware {
	
	Object getValue(String name);
	
	void setScreenApplicationContext(ScreenApplicationContext context);

}
