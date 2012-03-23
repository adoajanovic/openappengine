/**
 * 
 */
package com.openappengine.model.party;

import com.openappengine.model.specification.AbstractSpecification;
import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 * 
 */
public class PartySpecification extends AbstractSpecification<Party> implements
		ValueObject<PartySpecification> {

	private String description;

	private String partyType;

	private String currencyUom;

	public PartySpecification(String description, String partyType,
			String currencyUom) {
		super();
		this.description = description;
		this.partyType = partyType;
		this.currencyUom = currencyUom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getCurrencyUom() {
		return currencyUom;
	}

	public void setCurrencyUom(String currencyUom) {
		this.currencyUom = currencyUom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currencyUom == null) ? 0 : currencyUom.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((partyType == null) ? 0 : partyType.hashCode());
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
		PartySpecification other = (PartySpecification) obj;
		if (currencyUom == null) {
			if (other.currencyUom != null)
				return false;
		} else if (!currencyUom.equals(other.currencyUom))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (partyType == null) {
			if (other.partyType != null)
				return false;
		} else if (!partyType.equals(other.partyType))
			return false;
		return true;
	}

	@Override
	public boolean sameValueAs(PartySpecification other) {
		return this.equals(other);
	}

	@Override
	public boolean isSatisfiedBy(Party t) {
		return this.sameValueAs(new PartySpecification(t.getDescription(), t
				.getPartyType(), t.getPreferredCurrencyUom()));
	}

}
