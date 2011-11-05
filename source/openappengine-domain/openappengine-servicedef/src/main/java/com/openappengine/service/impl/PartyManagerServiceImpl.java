/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.factory.party.PartyAggregateFactory;
import com.openappengine.model.addressbook.Address;
import com.openappengine.model.addressbook.AddressRole;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.PartySpecification;
import com.openappengine.model.party.PersonSpecification;
import com.openappengine.repository.PartyManagerRepository;
import com.openappengine.service.IPartyManagerService;

/**
 * @author hrishi
 *
 */
public class PartyManagerServiceImpl implements IPartyManagerService {
	
	private PartyManagerRepository partyManagerRepository;
	
	private PartyAggregateFactory partyAggregateFactory;
	
	public void createContactMech(String externalId,PartyContactMech partyContactMech) {
		// TODO Auto-generated method stub
	}

	public void createContactMech(String externalId,
			List<PartyContactMech> partyContactMechs) {
	}

	public void setPartyManagerRepository(PartyManagerRepository partyManagerRepository) {
		this.partyManagerRepository = partyManagerRepository;
	}

	public void setPartyAggregateFactory(PartyAggregateFactory partyAggregateFactory) {
		this.partyAggregateFactory = partyAggregateFactory;
	}

	@Override
	public Party createNewParty(PartySpecification partySpecification) {
		Long sequenceId = partyManagerRepository.nextSequenceId();
		if(sequenceId == null) {
			sequenceId = Party.DEFAULT_START_EXTERNAL_ID;
		}
		
		Party partyModel = partyAggregateFactory.setupNewParty(partySpecification);
		partyModel.setExternalId(sequenceId.toString());
		
		partyManagerRepository.store(partyModel);
		return partyModel;
	}

	@Override
	public Party createPerson(PersonSpecification personSpecification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Party> findPartyById(String externalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Party> findPerson(PersonSpecification personSpecification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAddress(String externalId, Address address, AddressRole role) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Address> getAddressByRole(String externalId, AddressRole role) {
		// TODO Auto-generated method stub
		return null;
	}

}
