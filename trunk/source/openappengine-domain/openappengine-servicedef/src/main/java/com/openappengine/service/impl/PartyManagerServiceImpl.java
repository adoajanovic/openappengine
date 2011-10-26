/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.factory.party.PartyAggregateFactory;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.repository.PartyManagerRepository;
import com.openappengine.service.IPartyManagerService;

/**
 * @author hrishi
 *
 */
public class PartyManagerServiceImpl implements IPartyManagerService {
	
	private PartyManagerRepository partyManagerRepository;
	
	private PartyAggregateFactory partyAggregateFactory;
	
	/* (non-Javadoc)
	 * @see com.openappengine.service.IPartyManagerService#creatParty(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Party createNewParty(String description, String partyType,
			String currencyUom) {
		
		Long sequenceId = partyManagerRepository.nextSequenceId();
		if(sequenceId == null) {
			sequenceId = Party.DEFAULT_START_EXTERNAL_ID;
		}
		
		Party partyModel = partyAggregateFactory.setupNewParty(description, partyType, currencyUom);
		partyModel.setExternalId(sequenceId.toString());
		
		partyManagerRepository.store(partyModel);
		return partyModel;
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

	public void setPartyManagerRepository(PartyManagerRepository partyManagerRepository) {
		this.partyManagerRepository = partyManagerRepository;
	}

	public void setPartyAggregateFactory(PartyAggregateFactory partyAggregateFactory) {
		this.partyAggregateFactory = partyAggregateFactory;
	}

}
