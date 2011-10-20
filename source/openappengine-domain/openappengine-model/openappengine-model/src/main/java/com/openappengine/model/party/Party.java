package com.openappengine.model.party;

import java.io.Serializable;
import java.util.List;

import com.openappengine.model.contract.ContractHdr;


public class Party implements Serializable {

	private static final long serialVersionUID = 1L;

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

}