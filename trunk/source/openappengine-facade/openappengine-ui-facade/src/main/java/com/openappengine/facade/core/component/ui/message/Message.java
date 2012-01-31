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
	
	private String code;
	
	private int messageType;
	
	public Message() {
	}

	/**
	 * @param code
	 * @param messageType
	 */
	public Message(String code, int messageType) {
		super();
		this.code = code;
		this.messageType = messageType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

}
