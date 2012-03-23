/**
 * 
 */
package com.openappengine.factory.party;

import com.openappengine.factory.ModelFactory;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartySpecification;

/**
 * @author hrishi
 *
 */
public interface PartyAggregateFactory extends ModelFactory{
	
	/**
	 * Create a Party Model.
	 * @param partySpecification
	 * @return {@link Party}
	 */
	Party setupNewParty(PartySpecification partySpecification);
	

}
