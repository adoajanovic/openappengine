/**
 * 
 */
package com.openappengine.service;

import java.util.List;
import java.util.Set;

import com.openappengine.model.addressbook.Address;
import com.openappengine.model.addressbook.AddressRole;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.PartySpecification;
import com.openappengine.model.party.PersonSpecification;

/**
 * @author hrishi
 *
 */
public interface IPartyManagerService {

	/**
	 * Create New Party
	 * @param partySpecification
	 * @return
	 */
	Party createNewParty(PartySpecification partySpecification,Set<PartyContactMech> partyContactMechs,Set<Address> address);
	
	/**
	 * Create Person by Person Specification.
	 * @param personSpecification
	 */
	Party createPerson(PersonSpecification personSpecification);
	
	/**
	 * Find Parties by External Id.
	 * @param externalId
	 * @return List of Parties found.
	 */
	List<Party> findPartyById(String externalId);
	
	/**
	 * @param personSpecification.
	 * @return List of Persons found by PersonSpecifications.
	 */
	List<Party> findPerson(PersonSpecification personSpecification);
	
	/**
	 * Create a new ContactMech.
	 * @param externalId - Party ExternalId
	 * @param partyContactMech
	 */
	void createContactMech(String externalId, PartyContactMech partyContactMech);
	
	/**
	 * Create a new ContactMech.
	 * @param externalId
	 * @param partyContactMechs
	 */
	void createContactMech(String externalId, List<PartyContactMech> partyContactMechs);
	
	/**
	 * Create a new Address.
	 * @param externalId
	 * @param address
	 * @param role
	 */
	void createAddress(String externalId, Address address);
	
	/**
	 * Find Address by Address Type.
	 * @param externalId
	 * @param type
	 * @return
	 */
	List<Address> getAddressByRole(String externalId, AddressRole addressRole);
}
