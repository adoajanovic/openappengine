/**
 * 
 */
package com.openappengine.messages.party;

import com.openappengine.messages.api.MessagePayload;

/**
 * @author hrishi
 *
 */
public class CreatePartyRequest extends MessagePayload {

	private static final long serialVersionUID = 1L;
	
	private Party party;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
