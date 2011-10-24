/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class ContactMechDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String contactMechPurpose;
	
	private String contactMechType;
	
	private String infoString;

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
