/**
 * 
 */
package com.openappengine.facade.party.dto;

import com.openappengine.model.party.PartyContactMech;

/**
 * @author hrishi
 *
 */
public class ContactMechDTOAssembler {
	
	public PartyContactMech fromDTO(ContactMechDTO contactMechDTO){
		PartyContactMech partyContactMech = new PartyContactMech(contactMechDTO.getContactMechPurpose(),
				contactMechDTO.getContactMechType(), contactMechDTO
						.getInfoString());
		return partyContactMech;
	}

}
