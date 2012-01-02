package com.openappengine.facade.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.ui.preaction.PreAction;

public class PreActionHandler implements Executable {

	private List<PreAction> preActions = new ArrayList<PreAction>();

	protected final Logger logger = Logger.getLogger(getClass());

	@Override
	public Object execute(GuiApplicationContext screenContext) {
		// Handle the preactions.

		// Invoke the PreAction and store the variable in the current screen
		// context if value-field is specified.
		if (!preActions.isEmpty()) {
			// TODO - Convert to a Factory Abstract Implementation.

			for (PreAction preAction : preActions) {}/*{

				EntityFindOneActionHandler entityFindOneAction = (EntityFindOneActionHandler) preAction;

				// If Condition Expression is specified; evaluate the condition
				// otherwise execute the pre-action unconditionally.
				String conditionExpression = entityFindOneAction
						.getConditionExpression();
				if (!StringUtils.isEmpty(conditionExpression)) {
					ConditionExpressionEvaluator evaluator = new ConditionExpressionEvaluator();
					Boolean conditionEvaluation = evaluator
							.evaluate(conditionExpression);
					if (BooleanUtils.isFalse(conditionEvaluation)) {
						// Expression returned false.
						logger.info("Expression : {"
								+ conditionExpression
								+ "} returned false. ActionHandler will not be executed.");
						continue;
					}
					Object returnVal = preAction.execute(screenContext);
					// If ActionHandler has a value-field hold the return value from
					// the action in that value field in the ScreenContext.
					if (!StringUtils.isEmpty(entityFindOneAction
							.getValueField())) {
						// SAC
						// screenContext.getUIRoot().putVariable(entityFindOneAction.getValueField(),
						// returnVal);
					}
				}
			}*/
		}
		return null;
	}

	public List<PreAction> getPreActions() {
		return preActions;
	}

	public void setPreActions(List<PreAction> preActions) {
		this.preActions = preActions;
	}

	public void addPreAction(PreAction preAction) {
		if (preAction == null) {
			return;
		}

		this.preActions.add(preAction);
	}
}
