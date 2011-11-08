/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

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
public class PartyManagerServiceImpl extends ModelService implements IPartyManagerService {
	
	private PartyManagerRepository partyManagerRepository;
	
	private PartyAggregateFactory partyAggregateFactory;
	
	public void createContactMech(String externalId,PartyContactMech partyContactMech) {
		List<Party> partyById = this.findPartyById(externalId);
		if(partyById != null && !partyById.isEmpty()) {
			Party party = partyById.get(0);
			party.addPartyContactMech(partyContactMech);
			partyManagerRepository.store(party);
		}	
	}

	public void createContactMech(String externalId,List<PartyContactMech> partyContactMechs) {
	}

	public void setPartyManagerRepository(PartyManagerRepository partyManagerRepository) {
		this.partyManagerRepository = partyManagerRepository;
	}

	public void setPartyAggregateFactory(PartyAggregateFactory partyAggregateFactory) {
		this.partyAggregateFactory = partyAggregateFactory;
	}

	@Override
	@Transactional
	public Party createNewParty(PartySpecification partySpecification,Set<PartyContactMech> partyContactMeches,Set<Address> addresses) {
		Long sequenceId = partyManagerRepository.nextSequenceId();
		if(sequenceId == null) {
			sequenceId = Party.DEFAULT_START_EXTERNAL_ID;
		}
		
		Party partyModel = partyAggregateFactory.setupNewParty(partySpecification);
		partyModel.setExternalId(sequenceId.toString());
		partyModel.setAddresses(addresses);
		partyModel.setPartyContactMechs(partyContactMeches);
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
		List<Party> parties = partyManagerRepository.lookupPartyByExternalId(externalId);
		return parties;
	}

	@Override
	public List<Party> findPerson(PersonSpecification personSpecification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAddress(String externalId, Address address) {
		List<Party> list = this.findPartyById(externalId);
		if(list != null && !list.isEmpty()) {
			Party party = list.get(0);
			party.addAddress(address);
			partyManagerRepository.store(party);
		}
	}

	@Override
	public List<Address> getAddressByRole(String externalId, AddressRole role) {
		// TODO Auto-generated method stub
		return null;
	}

}
