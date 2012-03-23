/**
 * 
 */
package com.openappengine.messages.contract;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class CreateContractRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ContractHdr contractHdr;

	public ContractHdr getContractHdr() {
		return contractHdr;
	}

	public void setContractHdr(ContractHdr contractHdr) {
		this.contractHdr = contractHdr;
	}

}
