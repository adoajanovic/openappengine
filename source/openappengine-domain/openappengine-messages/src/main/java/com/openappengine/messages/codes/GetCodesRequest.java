/**
 * 
 */
package com.openappengine.messages.codes;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class GetCodesRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codeType;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}
