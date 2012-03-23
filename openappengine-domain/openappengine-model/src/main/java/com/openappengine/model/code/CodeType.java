package com.openappengine.model.code;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

@Entity
@Embeddable
@Table(name="CO_CODE_TYPE")
public class CodeType implements ValueObject<CodeType> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CT_CODE_TYPE_ID", unique=true, nullable=false)
	private int codeTypeId;

	@Column(name="CT_CODE_TYPE_VALUE", nullable=false, length=100)
	private String codeTypeValue;
	
	//bi-directional many-to-one association to SoSalesDet
	@OneToMany(mappedBy="codeType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Code> codes = new ArrayList<Code>();

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

	public List<Code> getCodes() {
		return codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}
	
	public void addCode(Code code) {
		if(code == null) {
			return;
		}
		
		this.addCode(code);
	}
	
}