/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContext extends AbstractActionContext {

	public DefaultActionContext(ExternalContext externalContext,ELContext elContext, ActionHandler actionHandler) {
		super(externalContext, elContext, actionHandler);
	}

}
