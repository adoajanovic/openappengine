/**
 * 
 */
package com.openappengine.facade.ui.action;

import org.apache.log4j.Logger;

import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.expression.ConditionExpressionEvaluator;


/**
 * @author hrishi
 *
 */
public abstract class ActionWrapper implements Action {
	
	protected final Logger logger = Logger.getLogger(getClass());

	protected Action wrappedAction;
	
	private ConditionExpressionEvaluator evaluator;
	
	protected Action getWrappedAction() {
		return wrappedAction;
	}

	protected abstract void setWrappedAction(Action action);

	@Override
	public Object execute(ScreenContext screenContext) {
		return wrappedAction.execute(screenContext);
	}
	
	protected Boolean evaluateConditionExpression(ScreenContext context,String expression) {
		if(evaluator == null) {
			evaluator = new ConditionExpressionEvaluator();
		}
		Boolean conditionEvaluation = evaluator.evaluate(expression,context.getScreen().getScreenVariables());
		return conditionEvaluation;
	}
}
