/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.support.DataBeanWrapper;

/**
 * @author hrishi
 * since Jan 3, 2012
 */
public class ActionHandlerWrapper extends DataBeanWrapper {

	public ActionHandlerWrapper(ActionHandler actionHandler) {
		super(actionHandler);
	}

	public ActionHandler getActionHandler() {
		return (ActionHandler) this.getWrappedInstance();
	}

	@Override
	public ActionHandler getWrappedInstance() {
		return (ActionHandler) super.getWrappedInstance();
	}
	
}
