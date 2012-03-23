/**
 * 
 */
package com.openappengine.gui.engine.core.el;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.log4j.Logger;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public class SimpleExpressionEvaluator extends AbstractJexlExpressionEvaluator {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Object evaluate(String expression) {
		try {
			Expression e = ExpressionFactory.createExpression(expression);
			JexlContext jexlContext = createJexlContext();
			Object result = e.evaluate(jexlContext);
			return result;
		} catch (Exception e) {
			//TODO - Should exception be thrown or silently caught.
			logger.error("Expression : " + expression + " could not be evaluated..Returning FALSE.");
			return Boolean.FALSE;
		}
	}

}
