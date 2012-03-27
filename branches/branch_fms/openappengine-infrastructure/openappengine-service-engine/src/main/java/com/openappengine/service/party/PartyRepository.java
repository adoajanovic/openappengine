/**
 * 
 */
package com.openappengine.service.party;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Party party = jdbcTemplate.queryForObject(sql, new Object[] {personId}, partyRowMapper());
		return party;
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
				p.isGender(),
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
