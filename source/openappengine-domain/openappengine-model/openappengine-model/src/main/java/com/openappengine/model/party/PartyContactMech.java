package com.openappengine.model.party;

import java.io.Serializable;


public class PartyContactMech implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int contactMechId;

	private String contactMechPurpose;

	private String contactMechType;

	private String infoString;

	private Party party;

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

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
    
}