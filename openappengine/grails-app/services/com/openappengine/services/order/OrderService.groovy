package com.openappengine.services.order


import com.openappengine.model.contract.Contract
import com.openappengine.model.contract.ContractLineItem;
import com.openappengine.model.fm.OhOrderHeader
import com.openappengine.model.fm.OiOrderItem
import com.openappengine.model.product.Product;

class OrderService {
	
	def createAllOrders(Date fromDate, Date toDate) {
		def c = Contract.createCriteria()
		def results = c.list {
			eq("active", Boolean.TRUE)
		}
		
		if(results != null && !results.isEmpty()) {
			for (Contract contract : results) {
				createOrder(contract.contractNumber, contract.fromDate, contract.toDate);
			}
		}
	}

    def createOrder(String contractNumber, Date fromDate, Date toDate) {
		if(contractNumber == null) {
			throw new IllegalArgumentException("Contract Number cannot be null.");
		}
		
		Contract contractInstance = Contract.findByContractNumber(contractNumber)
		if(contractInstance == null) {
			throw new IllegalArgumentException("No Instance of Contract found.");
		}
		
		def c = OhOrderHeader.createCriteria()
		def results = c.list {
			like("contractNumber",contractNumber)
			order("toDate","desc")
		}
		
		if(results != null && !results.isEmpty()) {
			OhOrderHeader orderHeader = results.get(0)
			if(orderHeader.toDate > fromDate) {
				return
			}
		}
		
		OhOrderHeader order = new OhOrderHeader()
		order.billingAccountId =  contractInstance.partyId
		order.fromDate =  fromDate
		order.toDate =  toDate
		order.contractNumber = contractNumber
		order.entryDate = new Date()
		order.orderDate = new Date()
		order.externalId = ""
		order.orderType = "SO"
		order.status = "NEW"
		
		List<ContractLineItem> lineItems = contractInstance.lineItems
		if(lineItems != null && !lineItems.isEmpty()) {
			int i = 0
			for (ContractLineItem lineItem : lineItems) {
				if(lineItem.active) {
					OiOrderItem item = new OiOrderItem()
					item.orderHeader = order
					item.orderItemSequenceId = i
					item.product = lineItem.product
					item.quantity = lineItem.quantity
					item.priceModified = false
					
					item.unitPrice = lineItem.product.getProductPrice(fromDate)
					i++
					
					order.addOrderItem(item)
				}
			}
		}
		
		order.save(flush:true)
    }
}
