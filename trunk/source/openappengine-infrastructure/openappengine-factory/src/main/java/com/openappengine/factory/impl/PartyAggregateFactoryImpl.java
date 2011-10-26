/**
 * 
 */
package com.openappengine.factory.impl;

import org.apache.commons.lang.Validate;

import com.openappengine.factory.party.PartyAggregateFactory;
import com.openappengine.model.party.Party;

/**
 * @author hrishi
 *
 */
public class PartyAggregateFactoryImpl implements PartyAggregateFactory {
	
	

	/* (non-Javadoc)
	 * @see com.openappengine.factory.party.PartyAggregateFactory#createModel(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Party setupNewParty(String description, String partyType,
			String currencyUom) {
		
		Validate.notNull(description, "[Party] : Description field cannot be null.");
		Validate.notNull(description, "[Party] : PartyType field cannot be null.");
		Validate.notNull(description, "[Party] : CurrencyUOM field cannot be null.");
		
		Party party = new Party();
		party.setDescription(description);
		party.setPartyType(partyType);
		party.setPreferredCurrencyUom(currencyUom);
		party.setStatus(Party.PARTY_STATUS_ACTIVE);
		return party;
	}

}
