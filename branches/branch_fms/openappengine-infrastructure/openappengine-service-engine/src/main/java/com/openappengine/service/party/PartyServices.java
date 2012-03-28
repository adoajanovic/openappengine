/**
 * 
 */
package com.openappengine.service.party;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.Person;
import com.openappengine.service.AbstractDomainService;
import com.openappengine.service.api.ServiceException;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class PartyServices extends AbstractDomainService {
	
	private Person person;
	
	private PartyRepository partyRepository = new PartyRepository();
	
	public void createPerson() throws ServiceException {
		if(person == null) {
			throw new ServiceException("Person cannot be null");
		}
		
		int partyId = person.getPartyId();
		Party party = partyRepository.findPersonById(partyId);
		if(party != null) {
			throw new ServiceException("Person Already Exists.");
		}
		
		Party newParty = new Party();
		newParty.setDescription(person.getComments());
		newParty.setExternalId("NA");
		newParty.setPartyType("PERSON");
		newParty.setPreferredCurrencyUom("INR");
		newParty.setStatus("ACTIVE");
		
		partyRepository.saveParty(newParty);
		person.setPartyId(newParty.getPartyId());
		
		partyRepository.savePerson(person);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
