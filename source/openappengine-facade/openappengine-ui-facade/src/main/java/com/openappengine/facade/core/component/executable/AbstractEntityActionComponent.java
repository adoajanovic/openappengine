/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;


/**
 * @author hrishi
 * since Jan 29, 2012
 */
public abstract class AbstractEntityActionComponent extends AbstractExecutableComponent {
	
	private static final long serialVersionUID = 1L;
	
	private String successMessage;

	@Override
	public abstract ActionRequest createActionRequest();

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
