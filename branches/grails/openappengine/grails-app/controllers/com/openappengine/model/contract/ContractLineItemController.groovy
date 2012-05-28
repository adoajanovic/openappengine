package com.openappengine.model.contract

import org.springframework.dao.DataIntegrityViolationException

class ContractLineItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contractLineItemInstanceList: ContractLineItem.list(params), contractLineItemInstanceTotal: ContractLineItem.count()]
    }

    def create() {
        [contractLineItemInstance: new ContractLineItem(params)]
    }

    def save() {
        def contractLineItemInstance = new ContractLineItem(params)
        if (!contractLineItemInstance.save(flush: true)) {
            render(view: "create", model: [contractLineItemInstance: contractLineItemInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), contractLineItemInstance.id])
        redirect(action: "show", id: contractLineItemInstance.id)
    }

    def show() {
        def contractLineItemInstance = ContractLineItem.get(params.id)
        if (!contractLineItemInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "list")
            return
        }

        [contractLineItemInstance: contractLineItemInstance]
    }

    def edit() {
        def contractLineItemInstance = ContractLineItem.get(params.id)
        if (!contractLineItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "list")
            return
        }

        [contractLineItemInstance: contractLineItemInstance]
    }

    def update() {
        def contractLineItemInstance = ContractLineItem.get(params.id)
        if (!contractLineItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (contractLineItemInstance.version > version) {
                contractLineItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'contractLineItem.label', default: 'ContractLineItem')] as Object[],
                          "Another user has updated this ContractLineItem while you were editing")
                render(view: "edit", model: [contractLineItemInstance: contractLineItemInstance])
                return
            }
        }

        contractLineItemInstance.properties = params

        if (!contractLineItemInstance.save(flush: true)) {
            render(view: "edit", model: [contractLineItemInstance: contractLineItemInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), contractLineItemInstance.id])
        redirect(action: "show", id: contractLineItemInstance.id)
    }

    def delete() {
        def contractLineItemInstance = ContractLineItem.get(params.id)
        if (!contractLineItemInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "list")
            return
        }

        try {
            contractLineItemInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'contractLineItem.label', default: 'ContractLineItem'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
