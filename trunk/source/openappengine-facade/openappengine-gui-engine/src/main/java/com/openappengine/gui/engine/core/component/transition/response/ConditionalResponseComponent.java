package com.openappengine.gui.engine.core.component.transition.response;

import com.openappengine.gui.engine.core.component.condition.ConditionComponent;

public class ConditionalResponseComponent extends AbstractTransitionalResponse {

	private static final long serialVersionUID = 1L;
	
	private ConditionComponent condition;
	
	@Override
	public String getComponentName() {
		return "conditional-response";
	}

	public ConditionComponent getCondition() {
		return condition;
	}

	public void setCondition(ConditionComponent condition) {
		this.condition = condition;
	}

}
