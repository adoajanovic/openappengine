/**
 * 
 */
package com.openappengine.facade.core.variable;

import com.openappengine.facade.core.context.ScreenApplicationContext;
import com.openappengine.facade.core.context.ScreenApplicationContextAware;

/**
 * Interface that resolve the value from the variable names.
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface VariableResolver extends ScreenApplicationContextAware {
	
	Object getValue(String name);
	
	void setScreenApplicationContext(ScreenApplicationContext context);

}
