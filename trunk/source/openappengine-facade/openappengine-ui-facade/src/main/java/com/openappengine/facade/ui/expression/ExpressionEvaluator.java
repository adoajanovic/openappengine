/**
 * 
 */
package com.openappengine.facade.ui.expression;

import java.util.Collection;

import com.openappengine.facade.ui.context.Variable;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public interface ExpressionEvaluator {
	
	Object evaluate(String expression,Collection<Variable> variables);

}
