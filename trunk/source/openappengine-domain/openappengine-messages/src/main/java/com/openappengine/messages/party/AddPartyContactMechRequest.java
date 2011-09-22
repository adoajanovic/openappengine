/**
 * 
 */
package com.openappengine.messages.party;

import java.util.List;

import com.openappengine.messages.api.MessagePayload;

/**
 * @author hrishikesh.joshi
 *
 */
public class AddPartyContactMechRequest extends MessagePayload {

	private static final long serialVersionUID = 1L;
	
	private Long partyId;
	
	private List<PartyContactMech> partyContactMeches;

	public List<PartyContactMech> getPartyContactMeches() {
		return partyContactMeches;
	}

	public void setPartyContactMeches(List<PartyContactMech> partyContactMeches) {
		this.partyContactMeches = partyContactMeches;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

}
