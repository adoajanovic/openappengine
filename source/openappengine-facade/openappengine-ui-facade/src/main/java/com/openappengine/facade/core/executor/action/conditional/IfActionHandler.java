package com.openappengine.facade.core.executor.action.conditional;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.Validate;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.CompositeActionHandler;

public class IfActionHandler extends CompositeActionHandler {
	
	private String conditionExpression;
	
	private List<IfActionHandler> elseifActions;
	
	private ActionHandler elseAction;
	
	public IfActionHandler(){
	}
	
	public IfActionHandler(String conditionExpression) {
		super();
		Validate.notEmpty(conditionExpression,"Condition Expression cannot be empty.");
		this.setConditionExpression(conditionExpression);
	}

	@Override
	public Object execute(ActionContext actionContext) {/*
		logger.info("Evaluating Conditional Expression : {" + conditionExpression + "}");
		Boolean eval = evaluateConditionExpression(screenContext, conditionExpression);
		if(BooleanUtils.isTrue(eval)) {
			logger.info("Conditional Expression : {" + conditionExpression + "} returned TRUE. > Calling IF ActionHandler.");
			return super.execute(screenContext);
		} else if(elseifActions != null && !elseifActions.isEmpty()) {
			for (IfActionHandler elseIfAction : elseifActions) {
				eval = evaluateConditionExpression(screenContext, elseIfAction.getConditionExpression());
				if(BooleanUtils.isFalse(eval)) {
					logger.info("Conditional Expression : {" + elseIfAction.getConditionExpression() + "} returned FALSE. > SKIPPING THE ELSE.");
					continue;
				}
				logger.info("Conditional Expression : {" + elseIfAction.getConditionExpression() + "} returned TRUE. > Calling IF ActionHandler.");
				return elseIfAction.execute(screenContext);
			}
		} else if(elseAction != null) {
			logger.info("Conditional Expression : {" + conditionExpression + "} returned FALSE. > Calling ELSE ActionHandler.");
			return elseAction.execute(screenContext);
		}
		logger.info("Conditional Expression : {" + conditionExpression + "} returned FALSE. > Wrapped ActionHandler not invoked.");
		return null;
	*/
		return null;
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

	@Override
	public String getName() {
		return "if";
	}

}
