package com.openappengine.gui.engine.core.executor.action.conditional;

import java.util.List;

import org.apache.commons.lang.Validate;

import com.openappengine.gui.engine.core.ActionRequest;
import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.executor.action.ActionContext;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;
import com.openappengine.gui.engine.core.executor.action.CompositeActionHandler;
import com.openappengine.gui.engine.core.executor.annotations.Action;

@Action(actionName="if")
public class IfActionHandler extends CompositeActionHandler {
	
	private String conditionExpression;
	
	private List<IfActionHandler> elseifActions;
	
	private ActionHandler elseAction;

	private ActionRequest actionRequest;
	
	public IfActionHandler(){
	}
	
	public IfActionHandler(String conditionExpression) {
		super();
		Validate.notEmpty(conditionExpression,"Condition Expression cannot be empty.");
		this.setConditionExpression(conditionExpression);
	}

	@Override
	protected void setWrappedAction(ActionHandler action) {
		//Set wrapped action as the conditional action.
		this.wrappedAction = action;
	}

	public ActionHandler getElseAction() {
		return elseAction;
	}

	public void setElseAction(ActionHandler elseAction) {
		this.elseAction = elseAction;
	}

	public List<IfActionHandler> getElseifActions() {
		return elseifActions;
	}

	public void setElseifActions(List<IfActionHandler> elseifActions) {
		this.elseifActions = elseifActions;
	}

	public String getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}

	public void setActionRequest(ActionRequest actionRequest) {
		this.actionRequest = actionRequest;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#supportsActionRequestXml(com.openappengine.gui.engine.core.action.xml.ActionRequestXml)
	 */
	@Override
	public boolean supportsActionRequestXml(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return false;
	}

}
