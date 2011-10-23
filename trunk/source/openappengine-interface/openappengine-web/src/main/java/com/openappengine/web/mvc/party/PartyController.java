/**
 * 
 */
package com.openappengine.web.mvc.party;

import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 *
 */
public class PartyController extends BaseWebController {
	
	private PartyModel partyModel;
	
	public String createParty() {
		return null;
	}

	public PartyModel getPartyModel() {
		return partyModel;
	}
	
	public void setPartyModel(PartyModel partyModel) {
		this.partyModel = partyModel;
	}

}
