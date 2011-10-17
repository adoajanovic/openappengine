package com.openappengine.model;

import java.io.Serializable;


public class CodeMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int codeMasterId;
	
	private String codeLabel;
	
	private String codeValue;
	
	private CodeType codeType;
	
	public int getCodeMasterId() {
		return codeMasterId;
	}

	public void setCodeMasterId(int codeMasterId) {
		this.codeMasterId = codeMasterId;
	}

	public String getCodeLabel() {
		return codeLabel;
	}

	public void setCodeLabel(String codeLabel) {
		this.codeLabel = codeLabel;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public CodeType getCodeType() {
		return codeType;
	}

	public void setCodeType(CodeType codeType) {
		this.codeType = codeType;
	}

    public CodeMaster() {
    }
    
    
}