/**
 * 
 */
package com.openappengine.facade.core.el;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;
import org.apache.log4j.Logger;

import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public class ConditionExpressionEvaluator extends AbstractJexlExpressionEvaluator {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	protected JexlContext createJexlContext(Collection<Variable> variables) {
		JexlContext jc = JexlHelper.createContext();
		
		Map<String, Object> vars = new HashMap<String, Object>();
		if(variables != null) {
			for (Variable variable : variables) {
				vars.put(variable.getName(), variable.getValue());
			}
		}
		
		jc.getVars().putAll(vars);
		return jc;
	}
	
	@Override
	public Boolean evaluate(String expression) {
		try {
			Expression e = ExpressionFactory.createExpression(expression);
			JexlContext jexlContext = createJexlContext();
			Object result = e.evaluate(jexlContext);
			if(result == null) {
				return Boolean.FALSE;
			}
			if(!(result instanceof Boolean)) {
				throw new RuntimeException("Expression : {" + expression + "} should evaluate to a boolean.");
			}
			return (Boolean) result;
		} catch (Exception e) {
			//TODO - Should exception be thrown or silently caught.
			logger.error("Expression : " + expression + " could not be evaluated..Returning FALSE.");
			return Boolean.FALSE;
		}
	}

}
