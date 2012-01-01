/**
 * 
 */
package com.openappengine.facade.core.el;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @Dec 26, 2011
 */
public class SimpleExpressionEvaluator extends AbstractJexlExpressionEvaluator {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	public SimpleExpressionEvaluator(GuiApplicationContext context) {
		Assert.notNull(context,"ScreenApplicationContext cannot be null.");
		setGuiApplicationContext(context);
	}
	
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
