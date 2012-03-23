/**
 * 
 */
package com.openappengine.gui.engine.core.component.transition;

import java.util.List;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.condition.ConditionComponent;
import com.openappengine.gui.engine.core.component.transition.response.ConditionalResponseComponent;
import com.openappengine.gui.engine.core.component.transition.response.DefaultResponseComponent;
import com.openappengine.gui.engine.core.component.transition.response.ErrorResponseComponent;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransitionComponent other = (TransitionComponent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
