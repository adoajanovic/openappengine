/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.request.DefaultActionRequest;


/**
 * @author hrishi
 * since Jan 29, 2012
 */
public abstract class AbstractEntityActionComponent extends AbstractExecutableComponent {
	
	private static final long serialVersionUID = 1L;
	
	private String successMessage;

	@Override
	public ActionRequest createActionRequest() {
		String actionName = this.getComponentName();
		ActionRequest actionRequest = new DefaultActionRequest(actionName,this);
		return actionRequest;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
