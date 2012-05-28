package com.openappengine.services.contract

import org.springframework.transaction.annotation.Transactional;

import com.openappengine.model.contract.Contract;
import com.openappengine.model.contract.ContractLineItem;

class ContractService {

	@Transactional
    def createService(Contract contract) throws ContractCreationException {
		try {
			if(contract.lineItems != null) {
				for (ContractLineItem lineItem : contract.lineItems) {
					lineItem.initLineItem();
				}
			}
			contract.save(flush:true)
		} catch(Exception e) {
			throw new ContractCreationException("Exception encountered while creating Contract.");
		}
    }
}
