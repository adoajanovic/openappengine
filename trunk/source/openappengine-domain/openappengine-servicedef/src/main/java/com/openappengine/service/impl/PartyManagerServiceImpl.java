/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.service.IPartyManagerService;

/**
 * @author hrishi
 *
 */
public class PartyManagerServiceImpl implements IPartyManagerService {

	/* (non-Javadoc)
	 * @see com.openappengine.service.IPartyManagerService#creatParty(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Party creatParty(String description, String partyType,
			String currencyUom) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IPartyManagerService#assignContactMechToParty(java.lang.String, com.openappengine.model.party.PartyContactMech)
	 */
	public void assignContactMechToParty(String externalId,
			PartyContactMech partyContactMech) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IPartyManagerService#assignContactMechToParty(java.lang.String, java.util.List)
	 */
	public void assignContactMechToParty(String externalId,
			List<PartyContactMech> partyContactMechs) {
		// TODO Auto-generated method stub

	}

}
