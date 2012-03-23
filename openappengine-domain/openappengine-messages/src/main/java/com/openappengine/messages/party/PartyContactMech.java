package com.openappengine.messages.party;

import java.io.Serializable;


/**
 * The persistent class for the pm_party_contact_mech database table.
 * 
 */
public class PartyContactMech implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int contactMechId;

	private String contactMechPurpose;

	private String contactMechType;

	private String infoString;

	private int partyId;

    public PartyContactMech() {
    }

	public int getContactMechId() {
		return contactMechId;
	}

	public void setContactMechId(int contactMechId) {
		this.contactMechId = contactMechId;
	}

	public String getContactMechPurpose() {
		return contactMechPurpose;
	}

	public void setContactMechPurpose(String contactMechPurpose) {
		this.contactMechPurpose = contactMechPurpose;
	}

	public String getContactMechType() {
		return contactMechType;
	}

	public void setContactMechType(String contactMechType) {
		this.contactMechType = contactMechType;
	}

	public String getInfoString() {
		return infoString;
	}

	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

}