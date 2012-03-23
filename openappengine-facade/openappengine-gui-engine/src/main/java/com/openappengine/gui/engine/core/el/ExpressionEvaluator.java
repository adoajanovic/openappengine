/**
 * 
 */
package com.openappengine.gui.engine.core.el;


/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public interface ExpressionEvaluator extends ElContextAware {
	
	Object evaluate(String expression);

}
