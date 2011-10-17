package com.openappengine.model;

import java.io.Serializable;
import java.util.List;

public class CodeType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int codeTypeId;

	private String codeTypeValue;

	private List<CodeMaster> codeMasters;

    public CodeType() {
    }

	public int getCodeTypeId() {
		return codeTypeId;
	}

	public void setCodeTypeId(int codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public String getCodeTypeValue() {
		return codeTypeValue;
	}

	public void setCodeTypeValue(String codeTypeValue) {
		this.codeTypeValue = codeTypeValue;
	}

	public List<CodeMaster> getCodeMasters() {
		return codeMasters;
	}

	public void setCodeMasters(List<CodeMaster> codeMasters) {
		this.codeMasters = codeMasters;
	}
    
}