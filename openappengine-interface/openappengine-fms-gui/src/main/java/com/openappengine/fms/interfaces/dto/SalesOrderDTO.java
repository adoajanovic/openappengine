/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class SalesOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CustomerDTO party = new CustomerDTO();

	public CustomerDTO getParty() {
		return party;
	}

	public void setParty(CustomerDTO party) {
		this.party = party;
	}

}
