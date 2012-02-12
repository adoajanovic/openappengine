/**
 * 
 */
package com.openappengine.gui.engine.fsm;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.component.condition.ConditionComponent;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.transition.TransitionActions;
import com.openappengine.gui.engine.core.component.transition.TransitionComponent;
import com.openappengine.gui.engine.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.gui.engine.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.gui.engine.core.executor.action.ActionDispatcher;
import com.openappengine.gui.engine.core.executor.action.dispatcher.ActionDispatcherFactory;


/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class WebTransitionEventListener extends TransitionEventListener {
	
	private Node node;
	
	/**
	 * @param transitions
	 */
	public WebTransitionEventListener(Node screen) {
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
					executeAction = (Boolean) getExpressionEvaluator().evaluate(guardConditionExpression);
				} 
				
				if(BooleanUtils.isTrue(executeAction)) {
					TransitionActions transitionActions = transition.getTransitionActions();
					if(transitionActions != null) {
						List<AbstractExecutableComponent> executables = transitionActions.getExecutables();
						if(executables != null) {
							for (AbstractExecutableComponent exec : executables) {
								ActionDispatcherFactory actionDispatcherFactory = new ActionDispatcherFactory();
								ActionDispatcher actionDispatcher = actionDispatcherFactory
										.createActionDispatcher(
												event.getElContext(),
												event.getExternalContext(),
												event.getMessageContext(),exec, null);
								
								ActionResponseXml actionResponseXml = actionDispatcher.execute();
								
								//TODO - To be taken care by the Action Handler
								/*if(exec.hasValueField()) {
									String valueField = exec.getValueField();
									event.getElContext().registerELContextVariable(valueField, result);
								}*/
							}
						}
												
						if(transition.getConditionalResponses() != null) {
							for (ConditionalResponseComponent conditionalResponse : transition.getConditionalResponses()) {
								//TODO If this outcome is equal to the exec outcome; then follow this outcome.
								String targetUrl = conditionalResponse.getUrl();
								
								ConditionComponent conditionalResponseCondition = conditionalResponse.getCondition();
								if(StringUtils.isNotEmpty(conditionalResponseCondition.getConditionExpression())) {
									if((Boolean) getExpressionEvaluator().evaluate(conditionalResponseCondition.getConditionExpression())) {
										//TODO - Break the execution of the remaining outcomes and go To this target Url.
										//Create a delegate to follow the transition.
									}
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
