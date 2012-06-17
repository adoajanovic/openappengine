/**
 * 
 */
package com.openappengine.messages.codes;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class Code implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codeId;
	
	private String codeValue;
	
	private String codeLabel;

	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeLabel() {
		return codeLabel;
	}

	public void setCodeLabel(String codeLabel) {
		this.codeLabel = codeLabel;
	}

}
