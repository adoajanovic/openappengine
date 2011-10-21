package com.openappengine.model.party;

import java.util.List;

import com.openappengine.model.contract.ContractHdr;
import com.openappengine.model.entity.Entity;
import com.openappengine.model.entity.Identity;


public class Party implements Entity<Party, Integer> {

	@Identity
	private int partyId;

	private String description;

	private String externalId;

	private String partyType;

	private String preferredCurrencyUom;

	private String status;

	private List<ContractHdr> contractHdrs;

	private List<PartyContactMech> partyContactMeches;

    public Party() {
    }

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getPreferredCurrencyUom() {
		return preferredCurrencyUom;
	}

	public void setPreferredCurrencyUom(String preferredCurrencyUom) {
		this.preferredCurrencyUom = preferredCurrencyUom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ContractHdr> getContractHdrs() {
		return contractHdrs;
	}

	public void setContractHdrs(List<ContractHdr> contractHdrs) {
		this.contractHdrs = contractHdrs;
	}

	public List<PartyContactMech> getPartyContactMeches() {
		return partyContactMeches;
	}

	public void setPartyContactMeches(List<PartyContactMech> partyContactMeches) {
		this.partyContactMeches = partyContactMeches;
	}

	@Override
	public boolean sameIdentityAs(Party other) {
		return this.sameIdentityAs(other);
	}

	@Override
	public Integer identity() {
		return partyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + partyId;
		result = prime * result
				+ ((partyType == null) ? 0 : partyType.hashCode());
		result = prime
				* result
				+ ((preferredCurrencyUom == null) ? 0 : preferredCurrencyUom
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Party other = (Party) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (partyId != other.partyId)
			return false;
		if (partyType == null) {
			if (other.partyType != null)
				return false;
		} else if (!partyType.equals(other.partyType))
			return false;
		if (preferredCurrencyUom == null) {
			if (other.preferredCurrencyUom != null)
				return false;
		} else if (!preferredCurrencyUom.equals(other.preferredCurrencyUom))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}