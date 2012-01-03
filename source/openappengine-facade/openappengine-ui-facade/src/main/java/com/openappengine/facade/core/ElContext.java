/**
 * 
 */
package com.openappengine.facade.core;

import java.util.Map;

import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishi
 * since Jan 3, 2012
 */
public interface ElContext {
	
	/**
	 * Get all EL Context Variables.
	 * @return
	 */
	Map<String, Variable> getElContextVariables();

	/**
	 * Evaluate EL Expression.
	 * @param expression
	 * @return
	 */
	Object evaluateElExpression(String expression);
	
}
