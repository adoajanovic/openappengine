package com.openappengine.model.code;

import java.io.Serializable;

import com.openappengine.model.valueobject.ValueObject;


public class Code implements ValueObject<Code> {
	
	private static final long serialVersionUID = 1L;

	private int codeId;
	
	private String codeLabel;
	
	private String codeValue;
	
	private CodeType codeType;
	
	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
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

    public Code() {
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeLabel == null) ? 0 : codeLabel.hashCode());
		result = prime * result
				+ ((codeValue == null) ? 0 : codeValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Code other = (Code) obj;
		if (codeLabel == null) {
			if (other.codeLabel != null)
				return false;
		} else if (!codeLabel.equals(other.codeLabel))
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		return true;
	}

	@Override
	public boolean sameValueAs(Code other) {
		return this.equals(other);
	}
    
}