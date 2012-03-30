/**
 * 
 */
package com.openappengine.service.party;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;
import com.openappengine.repository.GenericRepository;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class PartyRepository extends GenericRepository {
	
	public Party findPersonById(int personId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Person.class);
		criteria.add(Restrictions.eq("partyId", personId));
		List personList = hibernateTemplate.findByCriteria(criteria);
		if(personList != null && !personList.isEmpty()) {
			return (Party) personList.get(0);
		}
		return null;
	}
	
	public Person fetchPersonParty(int partyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Person.class);
		criteria.add(Restrictions.eq("partyId", partyId));
		List personList = hibernateTemplate.findByCriteria(criteria);
		if(personList != null && !personList.isEmpty()) {
			return (Person) personList.get(0);
		}
		return null;
	}
	
	public void saveContactMech(int partyId,PartyContactMech partyContactMech) {
		String sql = "INSERT INTO pm_party_contact_mech(PM_CONTACT_MECH_ID,PM_CONTACT_MECH_PURPOSE,PM_CONTACT_MECH_TYPE,PM_INFO_STRING,PM_PARTY_ID) VALUES(?,?,?,?,?)";
		int nextValue = incrementer.nextValue("pm_party_contact_mech_sequence");
		partyContactMech.setPartyContactMechId(nextValue);
		jdbcTemplate.update(sql, new Object[]{
				partyContactMech.getPartyContactMechId(),
				partyContactMech.getContactMechPurpose(),
				partyContactMech.getContactMechType(),
				partyContactMech.getInfoString(),
				partyId
		});
	}
	
	public void updateContactMech(int partyId,PartyContactMech partyContactMech) {
		String sql = "UPDATE pm_party_contact_mech SET PM_CONTACT_MECH_PURPOSE = ?,PM_CONTACT_MECH_TYPE = ?,PM_INFO_STRING = ?,PM_PARTY_ID = ? WHERE PM_CONTACT_MECH_ID = ?";
		jdbcTemplate.update(sql, new Object[]{
				partyContactMech.getContactMechPurpose(),
				partyContactMech.getContactMechType(),
				partyContactMech.getInfoString(),
				partyId,
				partyContactMech.getPartyContactMechId(),
		});
	}
	
	public List<Person> fetchAllActivePersonParty() {
		String sql = "SELECT DISTINCT pm_party.PM_PARTY_ID,PM_SALUTAION,PM_FIRST_NAME,PM_MIDDLE_NAME,PM_LAST_NAME,PM_NICK_NAME,PM_BIRTH_DATE,PM_DECEASED_DATE,PM_MARITAL_STATUS,PM_GENDER,PM_COMMENTS,PM_PASSPORT_EXPIRATION_DATE,PM_PASSPORT_NUMBER,PM_SSN,PM_SUFFIX " +
					 " FROM pm_person INNER JOIN pm_party WHERE pm_party.PM_STATUS = ?";
		List<Person> list = jdbcTemplate.query(sql, new Object[]{"ACTIVE"}, personRowMapper());
		return list;
	}

	private RowMapper<Person> personRowMapper() {
		return new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setPartyId(rs.getInt("pm_party.PM_PARTY_ID"));
				p.setSalutation(rs.getString("PM_SALUTAION"));
				p.setBirthDate(rs.getDate("PM_BIRTH_DATE"));
				p.setComments(rs.getString("PM_COMMENTS"));
				p.setDeceasedDate(rs.getDate("PM_DECEASED_DATE"));
				p.setFirstName(rs.getString("PM_FIRST_NAME"));
				p.setMiddleName(rs.getString("PM_MIDDLE_NAME"));
				p.setLastName(rs.getString("PM_LAST_NAME"));
				p.setGender(rs.getString("PM_GENDER"));
				return p;
			}
			
		};
	}
	
	public void saveParty(final Party party) {
		Assert.notNull(party, "Party is Null. Cannot save the party instance.");
		hibernateTemplate.save(party);
	}
	
	public void updatePerson(final Person p) {
		Assert.notNull(p, "Person is Null. Cannot update the person instance.");
		hibernateTemplate.update(p);
	}
	
	public void savePerson(final Person p) {
		Assert.notNull(p, "Person is Null. Cannot save the party instance.");
		hibernateTemplate.save(p);
	}

	/**
	 * @return
	 */
	private RowMapper<Party> partyRowMapper() {
		return new RowMapper<Party>() {
			@Override
			public Party mapRow(ResultSet rs, int rowNum) throws SQLException {
				Party party = new Party();
				party.setPartyId(rs.getInt("PM_PARTY_ID"));
				party.setDescription(rs.getString("PM_DESCRIPTION"));
				party.setExternalId(rs.getString("PM_EXTERNAL_ID"));
				party.setPartyType(rs.getString("PM_PARTY_TYPE"));
				party.setPreferredCurrencyUom(rs.getString("PM_PREFERRED_CURRENCY_UOM"));
				party.setStatus(rs.getString("PM_STATUS"));
				return party;
			}
		};
	}

}
