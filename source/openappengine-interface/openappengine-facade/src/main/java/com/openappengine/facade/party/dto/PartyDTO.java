/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class PartyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private String preferredCurrencyUom;
	
	private List<ContactMechDTO> partyContactMechs;
	
	private String partyType;
	
	public PartyDTO(String description, String preferredCurrencyUom, String partyType,
			List<ContactMechDTO> partyContactMechs) {
		super();
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
