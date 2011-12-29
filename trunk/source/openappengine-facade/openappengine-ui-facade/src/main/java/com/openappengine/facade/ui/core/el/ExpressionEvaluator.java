/**
 * 
 */
package com.openappengine.facade.ui.core.el;

import com.openappengine.facade.ui.core.context.ScreenApplicationContextAware;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public interface ExpressionEvaluator extends ScreenApplicationContextAware {
	
	Object evaluate(String expression);

}
