/**
 * 
 */
package com.openappengine.service.party;

import java.util.ArrayList;
import java.util.List;

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
		partyRepository.updatePerson(person);
	}
	
	public void createPerson() throws ServiceException {
		if(person == null) {
			throw new ServiceException("Person cannot be null");
		}
		
		if(partyContactMechs != null) {
			for (PartyContactMech contactMech : partyContactMechs) {
				person.getPartyContactMechs().add(contactMech);
				contactMech.setParty(person);
			}
		}
		
		//Save Party Contact Mechs.
		partyRepository.savePersonPartyWithDefaultValues(person);
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
