/**
 * 
 */
package com.openappengine.service.party;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
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
	
	private List<PartyContactMech> partyContactMechs;
	
	private List<Person> personPartyList = new ArrayList<Person>();
	
	private PartyRepository partyRepository = new PartyRepository();

	private int personId;
	
	public void updatePerson() throws ServiceException {
		int partyId = person.getPartyId();
		Party party = partyRepository.findPersonById(partyId);
		if(party == null) {
			throw new ServiceException("Person Does Not Exist.");
		}
		
		partyRepository.updatePerson(person);
		
		//Update Party Contact Mechs.
		if(partyContactMechs != null) {
			for (PartyContactMech partyContactMech : partyContactMechs) {
				partyRepository.updateContactMech(partyId,partyContactMech);
			}
		}
	}
	
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
		
		//Save Party Contact Mechs.
		if(partyContactMechs != null) {
			for (PartyContactMech partyContactMech : partyContactMechs) {
				partyRepository.saveContactMech(person.getPartyId(),partyContactMech);
			}
		}
	}

	public void getActiveParties() {
		personPartyList = partyRepository.fetchAllActivePersonParty();
	}
	
	public void findPersonById() {
		person = partyRepository.fetchPersonParty(getPersonId());
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersonPartyList() {
		return personPartyList;
	}

	public void setPersonPartyList(List<Person> personPartyList) {
		this.personPartyList = personPartyList;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public List<PartyContactMech> getPartyContactMechs() {
		return partyContactMechs;
	}

	public void setPartyContactMechs(List<PartyContactMech> partyContactMechs) {
		this.partyContactMechs = partyContactMechs;
	}

	

}
