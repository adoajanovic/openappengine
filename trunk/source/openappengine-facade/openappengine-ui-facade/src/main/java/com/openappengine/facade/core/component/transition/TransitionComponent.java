/**
 * 
 */
package com.openappengine.facade.core.component.transition;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.condition.ConditionComponent;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.facade.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.facade.core.component.transition.response.ErrorResponseComponent;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public class TransitionComponent implements GuiComponent {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private ConditionComponent condition;
	
	private TransitionActions transitionActions;
	
	private DefaultResponseComponent defaultResponseComponent;
	
	private ErrorResponseComponent errorResponseComponent;
	
	private List<ConditionalResponseComponent> conditionalResponses;

	@Override
	public String getComponentType() {
		return "transition-container";
	}

	@Override
	public String getComponentName() {
		return "transition";
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<GuiComponent> getChildComponents() {
		return null;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ConditionComponent getCondition() {
		return condition;
	}

	public void setCondition(ConditionComponent condition) {
		this.condition = condition;
	}

	public DefaultResponseComponent getDefaultResponseComponent() {
		return defaultResponseComponent;
	}

	public void setDefaultResponseComponent(DefaultResponseComponent defaultResponseComponent) {
		this.defaultResponseComponent = defaultResponseComponent;
	}

	public List<ConditionalResponseComponent> getConditionalResponses() {
		return conditionalResponses;
	}

	public void setConditionalResponses(List<ConditionalResponseComponent> conditionalResponses) {
		this.conditionalResponses = conditionalResponses;
	}

	public ErrorResponseComponent getErrorResponseComponent() {
		return errorResponseComponent;
	}

	public void setErrorResponseComponent(ErrorResponseComponent errorResponseComponent) {
		this.errorResponseComponent = errorResponseComponent;
	}

	public TransitionActions getTransitionActions() {
		return transitionActions;
	}

	public void setTransitionActions(TransitionActions transitionActions) {
		this.transitionActions = transitionActions;
	}
}
