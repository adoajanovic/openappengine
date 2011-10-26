/**
 * 
 */
package com.openappengine.service;

import java.util.List;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;

/**
 * @author hrishi
 *
 */
public interface IPartyManagerService {

	Party createNewParty(String description,String partyType,String currencyUom);
	
	void assignContactMechToParty(String externalId, PartyContactMech partyContactMech);
	
	void assignContactMechToParty(String externalId, List<PartyContactMech> partyContactMechs);
	
}
