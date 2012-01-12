/**
 * 
 */
package com.openappengine.facade.fsm;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.el.ConditionExpressionEvaluator;
import com.openappengine.facade.ui.context.ScreenApplicationContext;


/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class ScreenTransitionEventListener extends TransitionEventListener {
	
	private Node node;
	
	//Can be plugged to the node rather than the listener.
	//The variables should be attached to the expression evaluator.
	private ConditionExpressionEvaluator expressionEvaluator = new ConditionExpressionEvaluator();
	
	/**
	 * @param transitions
	 */
	public ScreenTransitionEventListener(Node screen) {
		super();
		this.node = screen;
	}

	@Override
	public void onApplicationEvent(TransitionEvent event) {
		List<Transition> activeTransitions = node.getTransitionsListeningToEvent(event);
		if(activeTransitions != null) {
			for (final Transition transition : activeTransitions) {
				String guardConditionExpression = transition.getGuardConditionExpression();
				Boolean executeAction = Boolean.TRUE;
				if(!StringUtils.isEmpty(guardConditionExpression)) {
					executeAction = expressionEvaluator.evaluate(guardConditionExpression);
				} 
				
				if(BooleanUtils.isTrue(executeAction)) {
					//Guard Condition is satisfied; so execute the action.
					//SAC
					Object execOutcome = transition.getExecutable().execute(null);
					
					if(transition.getConditionalOutcomes() != null) {
						for (TransitionOutcome outcome : transition.getConditionalOutcomes()) {
							//TODO If this outcome is equal to the exec outcome; then follow this outcome.
							String targetUrl = outcome.getTargetUrl();
							
							if(expressionEvaluator.evaluate(outcome.getConditionalExpression())) {
								//TODO - Break the execution of the remaining outcomes and go To this target Url.
								//Create a delegate to follow the transition.
							}
						}
					}
					
					//Follow Default Outcome.
					TransitionOutcome defaultOutcome = transition.getDefaultOutcome();
					//TODO
				}
			}
			//TODO - Handle default response here.
		}
	}

}
