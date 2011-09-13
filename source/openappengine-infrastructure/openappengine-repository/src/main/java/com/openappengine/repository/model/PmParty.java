package com.openappengine.repository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the pm_party database table.
 * 
 */
@Entity
@Table(name="pm_party")
public class PmParty extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARTY_ID", unique=true, nullable=false)
	private int partyId;

    @Lob()
	private String description;

	@Column(name="EXTERNAL_ID", length=20)
	private String externalId;

	@Column(name="PARTY_TYPE", nullable=false, length=100)
	private String partyType;

	@Column(name="PREFERRED_CURRENCY_UOM", length=5)
	private String preferredCurrencyUom;

	@Column(nullable=false, length=50)
	private String status;

	//bi-directional many-to-one association to CnContractHdr
	@OneToMany(mappedBy="pmParty")
	private List<CnContractHdr> cnContractHdrs;

	//bi-directional many-to-one association to PmPartyContactMech
	@OneToMany(mappedBy="pmParty")
	private List<PmPartyContactMech> pmPartyContactMeches;

    public PmParty() {
    }

	public int getPartyId() {
		return this.partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getPartyType() {
		return this.partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getPreferredCurrencyUom() {
		return this.preferredCurrencyUom;
	}

	public void setPreferredCurrencyUom(String preferredCurrencyUom) {
		this.preferredCurrencyUom = preferredCurrencyUom;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CnContractHdr> getCnContractHdrs() {
		return this.cnContractHdrs;
	}

	public void setCnContractHdrs(List<CnContractHdr> cnContractHdrs) {
		this.cnContractHdrs = cnContractHdrs;
	}

	public List<PmPartyContactMech> getPmPartyContactMeches() {
		return pmPartyContactMeches;
	}

	public void setPmPartyContactMeches(List<PmPartyContactMech> pmPartyContactMeches) {
		this.pmPartyContactMeches = pmPartyContactMeches;
	}
	
}