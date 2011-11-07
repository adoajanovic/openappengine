/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * @author hrishi
 *
 */
public class PartyCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Long PARTY_VALIDATION_ERROR = -999999L;
	
	private String description;
	
	private String preferredCurrencyUom;
	
	private String partyType;
	
	private List<PartyContactMechCommand> contactMechs = new ArrayList<PartyContactMechCommand>();
	
	private List<AddressCommand> addresses = new ArrayList<AddressCommand>();
	
	public PartyCommand(String description, String preferredCurrencyUom, String partyType) {
		super();
		Validate.notNull(description, "Description cannot be null");
		Validate.notNull(preferredCurrencyUom, "Preferred CurrencyUom cannot be null");
		Validate.notNull(partyType, "Party Type cannot be null");
		
		this.description = description;
		this.preferredCurrencyUom = preferredCurrencyUom;
		this.setPartyType(partyType);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreferredCurrencyUom() {
		return preferredCurrencyUom;
	}

	public void setPreferredCurrencyUom(String preferredCurrencyUom) {
		this.preferredCurrencyUom = preferredCurrencyUom;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public List<PartyContactMechCommand> getContactMechs() {
		return contactMechs;
	}

	public void setContactMechs(List<PartyContactMechCommand> contactMechs) {
		this.contactMechs = contactMechs;
	}
	
	public void addContactMech(PartyContactMechCommand partyContactMechCommand) {
		if(partyContactMechCommand == null) {
			return;
		}
		this.contactMechs.add(partyContactMechCommand);
	}

	public List<AddressCommand> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressCommand> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(AddressCommand addressCommand) {
		if(addressCommand == null) {
			return;
		}
		this.addresses.add(addressCommand);
	}

}
