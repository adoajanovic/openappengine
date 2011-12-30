/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.context.ScreenApplicationContext;
import com.openappengine.facade.core.el.ConditionExpressionEvaluator;


/**
 * @author hrishi
 *
 */
public abstract class ActionWrapper extends Action {
	
	protected final Logger logger = Logger.getLogger(getClass());

	protected Action wrappedAction;
	
	private ConditionExpressionEvaluator evaluator;
	
	protected Action getWrappedAction() {
		return wrappedAction;
	}

	protected abstract void setWrappedAction(Action action);

	@Override
	public Object execute(ScreenApplicationContext screenContext) {
		return wrappedAction.execute(screenContext);
	}
	
	protected Boolean evaluateConditionExpression(ScreenApplicationContext context,String expression) {
		if(evaluator == null) {
			evaluator = new ConditionExpressionEvaluator();
		}
		Boolean conditionEvaluation = evaluator.evaluate(expression);
		return conditionEvaluation;
	}
}
