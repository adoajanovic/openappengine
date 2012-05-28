package com.openappengine.model.contract

import org.springframework.dao.DataIntegrityViolationException

import com.openappengine.model.product.Product;
import com.openappengine.services.contract.ContractCreationException;

class ContractController {
	
	def contractService
	
	def sequenceGeneratorService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contractInstanceList: Contract.list(params), contractInstanceTotal: Contract.count()]
    }

    def create() {
		String contractNumber = sequenceGeneratorService.getNextSequenceNumber("Contract")
        def contractInstance= new Contract(params)
		contractInstance.contractNumber = contractNumber
		[contractInstance:contractInstance]
    }
	
	def addLineItem() {
		[lineItem : new ContractLineItem(params)]
		redirect(action: "show")
	}

    def save() {
    	def contractInstance = bindContract(params)
		try {
			contractService.createService(contractInstance)
		} catch(ContractCreationException e) {
			flash.message = message(code: 'default.created.error.message', args: [
				message(code: 'contract.label', default: 'Contract')])
			render(view: "create", model: [contractInstance: contractInstance])
			return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'contract.label', default: 'Contract'), contractInstance.contractId])
        redirect(action: "show", id: contractInstance.contractId)
    }
	
	def Contract bindContract(params)  {
		def contractInstance = new Contract()
		
		def count = params.itemCount.toInteger()
		for (int i=0; i<count; i++) {
			def lineItem = new ContractLineItem()
			lineItem.contract = contractInstance
			Product product = Product.get(params["lineItems["+i+"].productId"])
			lineItem.product = product
			bindData(lineItem, params["lineItems["+i+"]"])
			contractInstance.lineItems[i] = lineItem
		}
			  
		contractInstance.properties = params
		return contractInstance
	}

    def show() {
        def contractInstance = Contract.get(params.id)
        if (!contractInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "list")
            return
        }

        [contractInstance: contractInstance]
    }

    def edit() {
        def contractInstance = Contract.get(params.id)
        if (!contractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "list")
            return
        }

        [contractInstance: contractInstance]
    }

    def update() {
        def contractInstance = Contract.get(params.id)
        if (!contractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (contractInstance.version > version) {
                contractInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'contract.label', default: 'Contract')] as Object[],
                          "Another user has updated this Contract while you were editing")
                render(view: "edit", model: [contractInstance: contractInstance])
                return
            }
        }

        contractInstance.properties = params

        if (!contractInstance.save(flush: true)) {
            render(view: "edit", model: [contractInstance: contractInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'contract.label', default: 'Contract'), contractInstance.id])
        redirect(action: "show", id: contractInstance.id)
    }

    def delete() {
        def contractInstance = Contract.get(params.id)
        if (!contractInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "list")
            return
        }

        try {
            contractInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'contract.label', default: 'Contract'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
