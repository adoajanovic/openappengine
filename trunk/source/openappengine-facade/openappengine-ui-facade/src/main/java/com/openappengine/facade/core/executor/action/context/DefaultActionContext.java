/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionHandler;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContext extends AbstractActionContext {

	public DefaultActionContext(ELContext elContext, ActionHandler actionHandler) {
		super(elContext, actionHandler);
	}

}
