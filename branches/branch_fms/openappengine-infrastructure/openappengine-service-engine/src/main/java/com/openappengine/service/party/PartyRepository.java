/**
 * 
 */
package com.openappengine.service.party;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;
import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.RepositoryUtils;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class PartyRepository extends GenericRepository {
	
	public Party findPersonById(int personId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Person.class);
		criteria.add(Restrictions.eq("partyId", personId));
		@SuppressWarnings("rawtypes")
		List personList = hibernateTemplate.findByCriteria(criteria);
		Party party = null;
		if(personList != null && !personList.isEmpty()) {
			party = (Party) personList.get(0);;
		}
		return party;
	}
	
	public Person fetchPersonParty(int partyId) {
		Session session = RepositoryUtils.getExistingSession();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.eq("partyId", partyId));
		criteria.addOrder(Order.asc("partyId"));
		
		@SuppressWarnings("rawtypes")
		List personList = criteria.list();
		
		Person party = null;
		if(personList != null && !personList.isEmpty()) {
			party = (Person) personList.get(0);;
		}
		return party;
	}

	public void saveContactMech(PartyContactMech partyContactMech) {
		Assert.notNull(partyContactMech, "PartyContactMech found null. Cannot save PartyContactMech");
		Session session = RepositoryUtils.getExistingSession();
		int nextValue = incrementer.nextValue("pm_party_contact_mech_sequence");
		partyContactMech.setPartyContactMechId(nextValue);
		
		session.save(partyContactMech);
	}
	
	public void updateContactMech(int partyId,PartyContactMech partyContactMech) {
		Assert.notNull(partyContactMech, "PartyContactMech found null, cannot update PartyContactMech");
		Session session = RepositoryUtils.getExistingSession();
		if(partyContactMech.getPartyContactMechId() !=  0) {
			session.update(partyContactMech);
		} 
	}
	
	public List<Person> fetchAllActivePersonParty() {
		Session session = RepositoryUtils.getExistingSession();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.eq("status", Party.PARTY_STATUS_ACTIVE));
		@SuppressWarnings("unchecked")
		List<Person> list = criteria.list();
		return list;
	}

	public void updatePerson(final Person p) {
		Assert.notNull(p, "Person is Null. Cannot update the person instance.");
		Session session = RepositoryUtils.getExistingSession();
		session.update(p);
	}
	
	public void savePersonPartyWithDefaultValues(final Person p) {
		Session session = RepositoryUtils.getExistingSession();
		Assert.notNull(p, "Person is Null. Cannot save the party instance.");

		p.setDescription(p.getComments());
		p.setExternalId("NA");
		p.setPartyType("PERSON");
		p.setPreferredCurrencyUom("INR");
		p.setStatus("ACTIVE");
		
		session.save(p);
	}

}
