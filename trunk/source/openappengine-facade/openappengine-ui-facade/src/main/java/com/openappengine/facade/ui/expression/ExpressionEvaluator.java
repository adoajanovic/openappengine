/**
 * 
 */
package com.openappengine.facade.ui.expression;

import com.openappengine.facade.ui.context.ScreenContext;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public interface ExpressionEvaluator {
	
	Object evaluate(ScreenContext screenContext,String expression);

}
