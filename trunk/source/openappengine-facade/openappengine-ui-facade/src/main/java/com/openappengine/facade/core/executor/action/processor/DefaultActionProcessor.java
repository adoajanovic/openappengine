/**
 * 
 */
package com.openappengine.facade.core.executor.action.processor;

import org.springframework.util.Assert;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionProcessor;

/**
 * @author hrishi
 * since Jan 2, 2012
 */
public class DefaultActionProcessor implements ActionProcessor {

	@Override
	public Object performProcessing(ActionContext actionContext) {
		ActionHandler actionHandler = actionContext.getActionHandler();
		Assert.notNull(actionHandler,"Action Handler cannot be null.");
		Object result = actionHandler.execute();
		return result;
	}

}
