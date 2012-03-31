package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;


public class ContactMechDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int partyContactMechId;
	
	private String contactMechPurpose;

	private String contactMechType;

	private String infoString;

	public int getPartyContactMechId() {
		return partyContactMechId;
	}

	public void setPartyContactMechId(int partyContactMechId) {
		this.partyContactMechId = partyContactMechId;
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
}
