/**
 * 
 */
package com.openappengine.model.meta.search;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishikesh.joshi
 * 
 */
@Entity
@Table(name="AD_OPERATOR")
public class Operator implements ValueObject<Operator> {

	public static final String EQUALS = "=";

	public static final String GREATER = ">";
	
	public static final String GREATEREQUAL = ">=";
	
	public static final String LESS = "<";
	
	public static final String LESSEQUAL = "<=";
	
	public static final String LIKE = "LIKE";
	
	public static final String NOTEQUAL = "<>";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OP_OPERATOR_ID", unique=true, nullable=false)
	private int adOperatorId;
	
	@Column(name="OP_OPERATOR_NAME", nullable=false, length=50)
	private String operatorName;

	public int getAdOperatorId() {
		return adOperatorId;
	}

	public void setAdOperatorId(int adOperatorId) {
		this.adOperatorId = adOperatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public boolean sameValueAs(Operator other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operatorName == null) ? 0 : operatorName.hashCode());
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
		Operator other = (Operator) obj;
		if (operatorName == null) {
			if (other.operatorName != null)
				return false;
		} else if (!operatorName.equals(other.operatorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operator [operatorName=" + operatorName + "]";
	}
	
}
