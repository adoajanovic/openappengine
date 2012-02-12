/**
 * 
 */
package com.openappengine.facade.fsm;

import org.springframework.context.ApplicationListener;

import com.openappengine.facade.core.el.ExpressionEvaluator;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public abstract class TransitionEventListener implements ApplicationListener<TransitionEvent> {
	
	public abstract void onApplicationEvent(TransitionEvent event);
	
	//Can be plugged to the node rather than the listener.
	private ExpressionEvaluator expressionEvaluator;
	
	public ExpressionEvaluator getExpressionEvaluator() {
		return expressionEvaluator;
	}

	public void setExpressionEvaluator(ExpressionEvaluator expressionEvaluator) {
		this.expressionEvaluator = expressionEvaluator;
	}
}
