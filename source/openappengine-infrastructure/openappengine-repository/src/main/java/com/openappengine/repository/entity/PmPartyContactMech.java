package com.openappengine.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openappengine.repository.entity.GenericEntity;


/**
 * The persistent class for the pm_party_contact_mech database table.
 * 
 */
@Entity
@Table(name="pm_party_contact_mech")
public class PmPartyContactMech extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CM_CONTACT_MECH_ID", unique=true, nullable=false)
	private int cmContactMechId;

	@Column(name="CM_CONTACT_MECH_PURPOSE", nullable=false, length=50)
	private String cmContactMechPurpose;

	@Column(name="CM_CONTACT_MECH_TYPE", nullable=false, length=50)
	private String cmContactMechType;

	@Column(name="CM_INFO_STRING", nullable=false, length=100)
	private String cmInfoString;

	//bi-directional many-to-one association to PmParty
    @ManyToOne
	@JoinColumn(name="CM_PARTY_ID", nullable=false)
	private PmParty pmParty;

    public PmPartyContactMech() {
    }

	public int getCmContactMechId() {
		return this.cmContactMechId;
	}

	public void setCmContactMechId(int cmContactMechId) {
		this.cmContactMechId = cmContactMechId;
	}

	public String getCmContactMechPurpose() {
		return this.cmContactMechPurpose;
	}

	public void setCmContactMechPurpose(String cmContactMechPurpose) {
		this.cmContactMechPurpose = cmContactMechPurpose;
	}

	public String getCmContactMechType() {
		return this.cmContactMechType;
	}

	public void setCmContactMechType(String cmContactMechType) {
		this.cmContactMechType = cmContactMechType;
	}

	public String getCmInfoString() {
		return this.cmInfoString;
	}

	public void setCmInfoString(String cmInfoString) {
		this.cmInfoString = cmInfoString;
	}

	public PmParty getPmParty() {
		return this.pmParty;
	}

	public void setPmParty(PmParty pmParty) {
		this.pmParty = pmParty;
	}
	
}