/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * @author hrishi
 *
 */
public class PartyCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private String preferredCurrencyUom;
	
	private List<ContactMechDTO> partyContactMechs;
	
	private String partyType;
	
	public PartyCommand(String description, String preferredCurrencyUom, String partyType,
			List<ContactMechDTO> partyContactMechs) {
		super();
		Validate.notNull(description, "Description cannot be null");
		Validate.notNull(preferredCurrencyUom, "Description cannot be null");
		Validate.notNull(partyType, "Description cannot be null");
		
		this.description = description;
		this.preferredCurrencyUom = preferredCurrencyUom;
		this.setPartyType(partyType);
		this.partyContactMechs = partyContactMechs;
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

	public List<ContactMechDTO> getPartyContactMechs() {
		return partyContactMechs;
	}

	public void setPartyContactMechs(List<ContactMechDTO> partyContactMechs) {
		this.partyContactMechs = partyContactMechs;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

}
