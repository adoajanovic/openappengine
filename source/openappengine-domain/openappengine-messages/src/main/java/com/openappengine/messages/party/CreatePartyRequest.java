/**
 * 
 */
package com.openappengine.messages.party;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class CreatePartyRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Party party;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
