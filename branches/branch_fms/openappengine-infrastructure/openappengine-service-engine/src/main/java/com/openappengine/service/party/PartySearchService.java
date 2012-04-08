/**
 * 
 */
package com.openappengine.service.party;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.openappengine.model.party.Person;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishi
 *
 */
public class PartySearchService extends AbstractDomainService {
	
	private String firstName;
	
	private String middleName;

	private String lastName;
	
	private List<Person> persons;
	
	//Service Methods.
	public void findPersonsByName() {
		Session session = serviceContext.getHibernateSession();
		Criteria criteria = session.createCriteria(Person.class);

		criteria.add(Restrictions.like("firstName", firstName == null ? "" : firstName, MatchMode.ANYWHERE));
		criteria.add(Restrictions.like("middleName", middleName == null ? "" : middleName, MatchMode.ANYWHERE));
		criteria.add(Restrictions.like("lastName", lastName == null ? "" : lastName, MatchMode.ANYWHERE));
		persons = criteria.list();
		
	}

	//Accessors
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
