/**
 * 
 */
package com.ms.openapps.messages;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class BaseResponseMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Has the Service Returned an Error Message */
	private boolean inError;

	/* Error Messages */
	private List<String> errorMessages;
	
	/* Success Messages */
	private List<String> successMessages;

	/* Accessors */
	
	public boolean isInError() {
		return inError;
	}

	public void setInError(boolean inError) {
		this.inError = inError;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public List<String> getSuccessMessages() {
		return successMessages;
	}

	public void setSuccessMessages(List<String> successMessages) {
		this.successMessages = successMessages;
	}
	
}
