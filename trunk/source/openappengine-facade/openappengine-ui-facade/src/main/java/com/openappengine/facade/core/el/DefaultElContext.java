/**
 * 
 */
package com.openappengine.facade.core.el;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.facade.core.ElContext;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishi
 * since Jan 3, 2012
 */
public class DefaultElContext implements ElContext {
	
	private ExpressionEvaluator expressionEvaluator;
	
	private Map<String,Variable> contextVariables = new ConcurrentHashMap<String, Variable>();

	@Override
	public Map<String,Variable> getElContextVariables() {
		return contextVariables;
	}

	@Override
	public Object evaluateElExpression(String expression) {
		return expressionEvaluator.evaluate(expression);
	}

}
