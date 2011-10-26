/**
 * 
 */
package com.openappengine.factory.party;

import com.openappengine.factory.ModelFactory;
import com.openappengine.model.party.Party;

/**
 * @author hrishi
 *
 */
public interface PartyAggregateFactory extends ModelFactory{
	
	/**
	 * Create a Party Model.
	 * @param description
	 * @param partyType
	 * @param currencyUom
	 * @return {@link Party}
	 */
	Party setupNewParty(String description, String partyType,String currencyUom);
	

}
