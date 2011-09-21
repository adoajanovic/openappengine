/**
 * 
 */
package com.openappengine.web.mvc.party;

import com.openappengine.messages.party.CreatePartyRequest;
import com.openappengine.messages.party.Party;
import com.openappengine.servicedef.ServiceNames;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 *
 */
public class PartyController extends BaseWebController {
	
	private PartyModel partyModel;
	
	public String createParty() {
		Party party = new Party();
		party.setDescription(partyModel.getDescription());
		party.setExternalId(partyModel.getExternalId());
		party.setPartyId(partyModel.getPartyId());
		party.setPartyType(partyModel.getPartyType());
		party.setPreferredCurrencyUom(partyModel.getPreferredCurrencyUom());
		party.setStatus(partyModel.getStatus());
		
		CreatePartyRequest createPartyRequest = new CreatePartyRequest();
		createPartyRequest.setParty(party);
		callServiceFacade(createPartyRequest, ServiceNames.SERVICE_CREATE_PARTY);
		return null;
	}

	public PartyModel getPartyModel() {
		return partyModel;
	}
	
	public void setPartyModel(PartyModel partyModel) {
		this.partyModel = partyModel;
	}

}
