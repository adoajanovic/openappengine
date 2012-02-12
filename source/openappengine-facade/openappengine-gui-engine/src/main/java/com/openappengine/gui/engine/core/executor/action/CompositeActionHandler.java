/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

import org.apache.log4j.Logger;

import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.context.GuiApplicationContext;
import com.openappengine.gui.engine.core.el.ConditionExpressionEvaluator;


/**
 * CompositeActionHandler is an abstract class capable of executing Aggregated Actions/Composite Actions.
 * 
 * @author hrishi
 */
public abstract class CompositeActionHandler implements ActionHandler {
	
	protected final Logger logger = Logger.getLogger(getClass());

	protected ActionHandler wrappedAction;
	
	private ConditionExpressionEvaluator evaluator;
	
	protected ActionHandler getWrappedAction() {
		return wrappedAction;
	}

	protected abstract void setWrappedAction(ActionHandler action);

	protected Boolean evaluateConditionExpression(GuiApplicationContext context,String expression) {
		if(evaluator == null) {
			evaluator = new ConditionExpressionEvaluator();
		}
		Boolean conditionEvaluation = evaluator.evaluate(expression);
		return conditionEvaluation;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#setActionContext(com.openappengine.gui.engine.core.executor.action.ActionContext)
	 */
	@Override
	public void setActionContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#execute(com.openappengine.gui.engine.core.action.xml.ActionRequestXml)
	 */
	@Override
	public ActionResponseXml execute(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
