package com.openappengine.model.code;

import com.openappengine.model.valueobject.ValueObject;

public class CodeType implements ValueObject<CodeType> {
	
	private int codeTypeId;

	private String codeTypeValue;

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

	@Override
	public boolean sameValueAs(CodeType other) {
		return other != null && this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeTypeValue == null) ? 0 : codeTypeValue.hashCode());
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
		CodeType other = (CodeType) obj;
		if (codeTypeValue == null) {
			if (other.codeTypeValue != null)
				return false;
		} else if (!codeTypeValue.equals(other.codeTypeValue))
			return false;
		return true;
	}
	
}