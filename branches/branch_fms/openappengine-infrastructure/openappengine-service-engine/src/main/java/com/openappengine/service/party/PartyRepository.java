/**
 * 
 */
package com.openappengine.service.party;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.openappengine.model.party.Party;
import com.openappengine.model.party.Person;
import com.openappengine.repository.GenericRepository;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class PartyRepository extends GenericRepository {
	
	public Party findPersonById(int personId) {
		String sql = "SELECT * FROM pm_party WHERE PM_PARTY_ID = ?";
		Party party = null;
		try {
			party = jdbcTemplate.queryForObject(sql, new Object[] {personId}, partyRowMapper());
		} catch(EmptyResultDataAccessException e1) {
			//TODO - No Party Exists.
		}
		return party;
	}
	
	public Person fetchPersonParty(int partyId) {
		String sql = "SELECT pm_party.PM_PARTY_ID,PM_SALUTAION,PM_FIRST_NAME,PM_MIDDLE_NAME,PM_LAST_NAME,PM_NICK_NAME,PM_BIRTH_DATE,PM_DECEASED_DATE,PM_MARITAL_STATUS,PM_GENDER,PM_COMMENTS,PM_PASSPORT_EXPIRATION_DATE,PM_PASSPORT_NUMBER,PM_SSN,PM_SUFFIX " +
				 " FROM pm_person INNER JOIN pm_party WHERE pm_party.PM_PARTY_ID = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {partyId}, personRowMapper());
		} catch(EmptyResultDataAccessException e1) {
			//TODO - No Party Exists.
		}
		
		return null;
		
	}
	
	public List<Person> fetchAllActivePersonParty() {
		String sql = "SELECT pm_party.PM_PARTY_ID,PM_SALUTAION,PM_FIRST_NAME,PM_MIDDLE_NAME,PM_LAST_NAME,PM_NICK_NAME,PM_BIRTH_DATE,PM_DECEASED_DATE,PM_MARITAL_STATUS,PM_GENDER,PM_COMMENTS,PM_PASSPORT_EXPIRATION_DATE,PM_PASSPORT_NUMBER,PM_SSN,PM_SUFFIX " +
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
	
	public int saveParty(final Party party) {
		String sql = "INSERT INTO pm_party(PM_PARTY_ID,PM_DESCRIPTION,PM_EXTERNAL_ID,PM_PARTY_TYPE,PM_PREFERRED_CURRENCY_UOM,PM_STATUS) VALUES(?,?,?,?,?,?)";
		
		int partyId = incrementer.nextValue("pm_party_sequence");
		party.setPartyId(partyId);
		
		int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, party.getPartyId());
				ps.setString(2, party.getDescription());
				ps.setString(3, party.getExternalId());
				ps.setString(4, party.getPartyType());
				ps.setString(5, party.getPreferredCurrencyUom());
				ps.setString(6, party.getStatus());
			}
		});
		return update;
	}
	
	public int savePerson(final Person p) {
		String sqlInsert = "INSERT INTO pm_person(PM_PARTY_ID,PM_SALUTAION,PM_FIRST_NAME,PM_MIDDLE_NAME,PM_LAST_NAME,PM_NICK_NAME,PM_BIRTH_DATE,PM_DECEASED_DATE,PM_MARITAL_STATUS,PM_GENDER,PM_COMMENTS,PM_PASSPORT_EXPIRATION_DATE,PM_PASSPORT_NUMBER,PM_SSN,PM_SUFFIX) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int update = jdbcTemplate.update(sqlInsert, new Object[]{
				p.getPartyId(),
				p.getSalutation(),
				p.getFirstName(),
				p.getMiddleName(),
				p.getLastName(),
				p.getNickname(),
				p.getBirthDate(),
				p.getDeceasedDate(),
				p.getMaritalStatus(),
				p.getGender(),
				p.getComments(),
				p.getPassportExpireDate(),
				p.getPassportNumber(),
				p.getSocialSecurityNumber(),
				p.getSuffix()
		});
		
		return update;
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
