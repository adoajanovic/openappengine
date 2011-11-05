/**
 * 
 */
package com.openappengine.facade.party;

import java.util.List;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.party.dto.PartyCommand;
import com.openappengine.facade.party.dto.PartyContactMechCommand;

/**
 * @author hrishi
 *
 */
public interface PartyManagerFacade {
	
	/**
	 * @param codeType
	 * @return List all Codes of the Given Code Type.
	 */
	List<CodeDTO> listAllCodes(String codeType);
	
	/**
	 * Create a new Party and return the External Id (Tracking Id) of the created party.
	 * @param partyCommand
	 * @return
	 */
	String createParty(PartyCommand partyCommand);
	
	/**
	 * Assign the Contact Mech to the party.
	 * @param partyExternal
	 * @param partyContactMechCommand
	 */
	void assignContactMechToParty(String partyExternal,PartyContactMechCommand partyContactMechCommand);
	
}
