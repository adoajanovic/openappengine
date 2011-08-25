package com.ms.openapps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pm_party database table.
 * 
 */
@Entity
@Table(name="pm_party")
public class PmParty extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARTY_ID", unique=true, nullable=false)
	private int partyId;

    @Lob()
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="EXTERNAL_ID", length=20)
	private String externalId;

	@Column(name="PARTY_TYPE", nullable=false, length=5)
	private String partyType;

	@Column(name="PREFERRED_CURRENCY_UOM", length=5)
	private String preferredCurrencyUom;

	@Column(name="STATUS", nullable=false, length=5)
	private String status;

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
	
}