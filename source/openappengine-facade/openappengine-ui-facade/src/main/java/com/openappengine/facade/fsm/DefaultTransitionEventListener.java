/**
 * 
 */
package com.openappengine.facade.fsm;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.component.condition.ConditionComponent;
import com.openappengine.facade.core.component.transition.TransitionActions;
import com.openappengine.facade.core.component.transition.TransitionComponent;
import com.openappengine.facade.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.facade.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.facade.core.el.ConditionExpressionEvaluator;
import com.openappengine.facade.core.executor.action.Executable;


/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class DefaultTransitionEventListener extends TransitionEventListener {
	
	private Node node;
	
	//Can be plugged to the node rather than the listener.
	//The variables should be attached to the expression evaluator.
	private ConditionExpressionEvaluator expressionEvaluator = new ConditionExpressionEvaluator();
	
	/**
	 * @param transitions
	 */
	public DefaultTransitionEventListener(Node screen) {
		super();
		this.node = screen;
	}

	@Override
	public void onApplicationEvent(TransitionEvent event) {
		List<TransitionComponent> activeTransitions = node.getTransitionsListeningToEvent(event);
		if(activeTransitions != null) {
			for (final TransitionComponent transition : activeTransitions) {
				ConditionComponent condition = transition.getCondition();
				String guardConditionExpression = "true";
				if(condition != null) {
					guardConditionExpression = condition.getConditionExpression();
				}
				
				Boolean executeAction = Boolean.TRUE;
				if(!StringUtils.isEmpty(guardConditionExpression)) {
					executeAction = expressionEvaluator.evaluate(guardConditionExpression);
				} 
				
				if(BooleanUtils.isTrue(executeAction)) {
					TransitionActions transitionActions = transition.getTransitionActions();
					if(transitionActions != null) {
						List<Executable> executables = transitionActions.getExecutables();
						//TODO - Execute the Transition Actions.
						
						if(transition.getConditionalResponses() != null) {
							for (ConditionalResponseComponent conditionalResponse : transition.getConditionalResponses()) {
								//TODO If this outcome is equal to the exec outcome; then follow this outcome.
								String targetUrl = conditionalResponse.getUrl();
								
								ConditionComponent conditionalResponseCondition = conditionalResponse.getCondition();
								if(expressionEvaluator.evaluate(conditionalResponseCondition.getConditionExpression())) {
									//TODO - Break the execution of the remaining outcomes and go To this target Url.
									//Create a delegate to follow the transition.
								}
							}
						}
						
						//Follow Default Outcome.
						DefaultResponseComponent defaultResponse = transition.getDefaultResponseComponent();
						//TODO
					}
				}
			}
			//TODO - Handle default response here.
		}
	}

}
