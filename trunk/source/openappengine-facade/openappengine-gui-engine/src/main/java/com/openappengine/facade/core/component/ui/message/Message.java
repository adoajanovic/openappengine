/**
 * 
 */
package com.openappengine.facade.core.component.ui.message;

import java.io.Serializable;

/**
 * @author hrishi
 * since Jan 29, 2012
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String elementId;
	
	private String code;
	
	private Object[] messageArgs;
	
	private int severity;
	
	public Message() {
	}

	/**
	 * @param code
	 * @param severity
	 */
	public Message(String code, int severity) {
		super();
		this.code = code;
		this.severity = severity;
	}
	
	

	/**
	 * @param code
	 * @param messageArgs
	 * @param severity
	 */
	public Message(String code,int severity, Object[] messageArgs) {
		super();
		this.code = code;
		this.messageArgs = messageArgs;
		this.severity = severity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMessageSeverity() {
		return severity;
	}

	public void setMessageSeverity(int messageType) {
		this.severity = messageType;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(Object[] messageArgs) {
		this.messageArgs = messageArgs;
	}

}
