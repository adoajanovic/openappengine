/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import com.openappengine.model.party.PartyContactMech;

/**
 * @author hrishi
 *
 */
public class ContactMechDTOAssembler {
	
	public ContactMechDTO toDTO(PartyContactMech contactMech) {
		ContactMechDTO dto = new ContactMechDTO();
		dto.setContactMechPurpose(contactMech.getContactMechPurpose());
		dto.setContactMechType(contactMech.getContactMechType());
		dto.setInfoString(contactMech.getInfoString());
		dto.setPartyContactMechId(contactMech.getPartyContactMechId());
		return dto;
	}

	public PartyContactMech fromDTO(ContactMechDTO dto) {
		PartyContactMech contactMech = new PartyContactMech();
		contactMech.setContactMechPurpose(dto.getContactMechPurpose());
		contactMech.setContactMechType(dto.getContactMechType());
		contactMech.setInfoString(dto.getInfoString());
		contactMech.setPartyContactMechId(dto.getPartyContactMechId());
		return contactMech;
	}
}
