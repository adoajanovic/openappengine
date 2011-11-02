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
	
	public PartyContactMech fromDTO(PartyContactMechCommand partyContactMechCommand){
		PartyContactMech partyContactMech = new PartyContactMech(partyContactMechCommand.getContactMechPurpose(),
				partyContactMechCommand.getContactMechType(), partyContactMechCommand
						.getInfoString());
		return partyContactMech;
	}

}
