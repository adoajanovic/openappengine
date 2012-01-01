/**
 * 
 */
package com.openappengine.facade.core.el;

import com.openappengine.facade.core.context.GuiApplicationContextAware;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public interface ExpressionEvaluator extends GuiApplicationContextAware {
	
	Object evaluate(String expression);

}
