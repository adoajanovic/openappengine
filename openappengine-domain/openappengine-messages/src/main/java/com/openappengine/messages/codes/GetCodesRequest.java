/**
 * 
 */
package com.openappengine.messages.codes;

import com.openappengine.messages.api.MessagePayload;

/**
 * @author hrishi
 *
 */
public class GetCodesRequest extends MessagePayload {

	private static final long serialVersionUID = 1L;
	
	private String codeType;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}
