/**
 * 
 */
package com.openappengine.facade.ui.expression;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.context.Variable;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public class ConditionExpressionEvaluator implements ExpressionEvaluator {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private Collection<Variable> screenVariables;
	
	protected JexlContext createJexlContext(ScreenContext screenContext) {
		JexlContext jc = JexlHelper.createContext();
		
		Map<String, Object> vars = new HashMap<String, Object>();
		screenVariables = screenContext.getScreenVariables();
		if(screenVariables != null) {
			for (Variable variable : screenVariables) {
				vars.put(variable.getName(), variable.getValue());
			}
		}
		
		jc.getVars().putAll(vars);
		return jc;
	}
	
	@Override
	public Boolean evaluate(ScreenContext screenContext,String expression) {
		try {
			Expression e = ExpressionFactory.createExpression(expression);
			JexlContext jexlContext = createJexlContext(screenContext);
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
