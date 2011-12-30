package com.openappengine.facade.ui.action.conditional;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.Validate;

import com.openappengine.facade.core.context.ScreenApplicationContext;
import com.openappengine.facade.ui.action.Action;
import com.openappengine.facade.ui.action.ActionWrapper;

public class IfAction extends ActionWrapper {
	
	private String conditionExpression;
	
	private List<IfAction> elseifActions;
	
	private Action elseAction;
	
	public IfAction(String conditionExpression) {
		super();
		Validate.notEmpty(conditionExpression,"Condition Expression cannot be empty.");
		this.setConditionExpression(conditionExpression);
	}

	@Override
	public Object execute(ScreenApplicationContext screenContext) {
		logger.info("Evaluating Conditional Expression : {" + conditionExpression + "}");
		Boolean eval = evaluateConditionExpression(screenContext, conditionExpression);
		if(BooleanUtils.isTrue(eval)) {
			logger.info("Conditional Expression : {" + conditionExpression + "} returned TRUE. > Calling IF Action.");
			return super.execute(screenContext);
		} else if(elseifActions != null && !elseifActions.isEmpty()) {
			for (IfAction elseIfAction : elseifActions) {
				eval = evaluateConditionExpression(screenContext, elseIfAction.getConditionExpression());
				if(BooleanUtils.isFalse(eval)) {
					logger.info("Conditional Expression : {" + elseIfAction.getConditionExpression() + "} returned FALSE. > SKIPPING THE ELSE.");
					continue;
				}
				logger.info("Conditional Expression : {" + elseIfAction.getConditionExpression() + "} returned TRUE. > Calling IF Action.");
				return elseIfAction.execute(screenContext);
			}
		} else if(elseAction != null) {
			logger.info("Conditional Expression : {" + conditionExpression + "} returned FALSE. > Calling ELSE Action.");
			return elseAction.execute(screenContext);
		}
		logger.info("Conditional Expression : {" + conditionExpression + "} returned FALSE. > Wrapped Action not invoked.");
		return null;
	}

	@Override
	protected void setWrappedAction(Action action) {
		//Set wrapped action as the conditional action.
		this.wrappedAction = action;
	}

	public Action getElseAction() {
		return elseAction;
	}

	public void setElseAction(Action elseAction) {
		this.elseAction = elseAction;
	}

	public List<IfAction> getElseifActions() {
		return elseifActions;
	}

	public void setElseifActions(List<IfAction> elseifActions) {
		this.elseifActions = elseifActions;
	}

	public String getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}

}
