/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

/**
 * @author hrishi
 *
 */
public class PartyContactMechCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String contactMechPurpose;
	
	private String contactMechType;
	
	private String infoString;
	
	public PartyContactMechCommand(String contactMechPurpose,
			String contactMechType, String infoString) {
		Validate.notEmpty(contactMechPurpose,"ContactMech : Purpose Cannot be null.");
		Validate.notEmpty(contactMechType,"ContactMech : Type Cannot be null.");
		Validate.notEmpty(infoString,"ContactMech : InfoString Cannot be null.");
		this.contactMechPurpose = contactMechPurpose;
		this.contactMechType = contactMechType;
		this.infoString = infoString;
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
