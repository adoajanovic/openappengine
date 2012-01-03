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
public interface ELContext {
	
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
	Object evaluateELExpression(String expression);
	
	/**
	 * Register Variable with EL Context.
	 * @param name
	 * @param value
	 */
	public void registerELContextVariable(String name,Object value);
	
	/**
	 * Get a variable from the EL Context.
	 * @param name
	 * @return
	 */
	public Object getVariable(String name);
	
	/**
	 * @param name
	 * @param t
	 * @return
	 */
	public <T> T getVariable(String name,Class<T> t);
	
}
