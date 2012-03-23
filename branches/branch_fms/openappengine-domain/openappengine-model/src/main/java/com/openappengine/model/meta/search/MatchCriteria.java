/**
 * 
 */
package com.openappengine.model.meta.search;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;
import com.truemesh.squiggle.output.Output;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_MATCH_CRITERIA")
public class MatchCriteria extends Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="MC_NAME", nullable=false, length=50)
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER)
	private ADColumn adColumn;
	
	@OneToOne(fetch=FetchType.EAGER)
	private ADTable adTable;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Operator operator;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ADColumn getAdColumn() {
		return adColumn;
	}

	public void setAdColumn(ADColumn adColumn) {
		this.adColumn = adColumn;
	}

	public ADTable getAdTable() {
		return adTable;
	}

	public void setAdTable(ADTable adTable) {
		this.adTable = adTable;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public boolean sameValueAs(MatchCriteria other) {
		return this.equals(other);
	}
	
	@Override
	public String toString() {
		return "Criteria [" + adTable + "." + adColumn + " " + operator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adColumn == null) ? 0 : adColumn.hashCode());
		result = prime * result + ((adTable == null) ? 0 : adTable.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
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
		MatchCriteria other = (MatchCriteria) obj;
		if (adColumn == null) {
			if (other.adColumn != null)
				return false;
		} else if (!adColumn.equals(other.adColumn))
			return false;
		if (adTable == null) {
			if (other.adTable != null)
				return false;
		} else if (!adTable.equals(other.adTable))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
	
	public void write(Output out) {
    	out.print(adTable + "." + adColumn + " " + "=" + " " + ":" + name);
    }
}
