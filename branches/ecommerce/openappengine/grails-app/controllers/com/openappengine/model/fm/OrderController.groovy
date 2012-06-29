package com.openappengine.model.fm

import org.springframework.dao.DataIntegrityViolationException

import com.openappengine.model.contract.Contract;
import com.openappengine.model.product.Product

class OrderController {
	
	def orderService
	
	def sequenceGeneratorService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ohOrderHeaderInstanceList: OhOrderHeader.list(params), ohOrderHeaderInstanceTotal: OhOrderHeader.count()]
    }
	
	def filter() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def c  = OhOrderHeader.createCriteria()
		def orders = c.list {
			like("contractNumber", "${params.contractNumber}%")
			like("externalId", "${params.orderNumber}%")
		}
		
		if(orders?.size() != 0) {
			flash.message = message(code: 'default.records_not_found.message')
		}
		
		[ohOrderHeaderInstanceList: orders, ohOrderHeaderInstanceTotal: orders.size()]
	}

    def create() {
		String orderNumber = sequenceGeneratorService.getNextSequenceNumber("Order")
		def ohOrderHeaderInstance= new OhOrderHeader(params)
		ohOrderHeaderInstance.externalId = orderNumber
        [ohOrderHeaderInstance: ohOrderHeaderInstance]
    }
	
    def save() {
        def ohOrderHeaderInstance = bindOrder(params)
        if (!ohOrderHeaderInstance.save(flush: true)) {
            render(view: "create", model: [ohOrderHeaderInstance: ohOrderHeaderInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'),
			ohOrderHeaderInstance.id
		])
		
		redirect(action: "show", id: ohOrderHeaderInstance.id)
    }
	
	def OhOrderHeader bindOrder(params)  {
		def orderHeaderInstance = new OhOrderHeader()
		
		def count = params.itemCount.toInteger()
		
		for (int i=0; i<count; i++) {
			def lineItem = new OiOrderItem()
			lineItem.orderHeader = orderHeaderInstance
			Product product = Product.get(params["lineItems["+i+"].productId"])
			lineItem.product = product
			
			bindData(lineItem, params["lineItems["+i+"]"])
			orderHeaderInstance.orderItems[i] = lineItem
		}
			  
		orderHeaderInstance.properties = params
		return orderHeaderInstance
	}

    def show() {
        def ohOrderHeaderInstance = OhOrderHeader.get(params.id)
        if (!ohOrderHeaderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "list")
            return
        }

        [ohOrderHeaderInstance: ohOrderHeaderInstance]
    }

    def edit() {
        def ohOrderHeaderInstance = OhOrderHeader.get(params.id)
        if (!ohOrderHeaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "list")
            return
        }

        [ohOrderHeaderInstance: ohOrderHeaderInstance]
    }

    def update() {
        def ohOrderHeaderInstance = OhOrderHeader.get(params.id)
        if (!ohOrderHeaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (ohOrderHeaderInstance.version > version) {
                ohOrderHeaderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader')] as Object[],
                          "Another user has updated this OhOrderHeader while you were editing")
                render(view: "edit", model: [ohOrderHeaderInstance: ohOrderHeaderInstance])
                return
            }
        }

        ohOrderHeaderInstance.properties = params

        if (!ohOrderHeaderInstance.save(flush: true)) {
            render(view: "edit", model: [ohOrderHeaderInstance: ohOrderHeaderInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), ohOrderHeaderInstance.id])
        redirect(action: "show", id: ohOrderHeaderInstance.id)
    }

    def delete() {
        def ohOrderHeaderInstance = OhOrderHeader.get(params.id)
        if (!ohOrderHeaderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "list")
            return
        }

        try {
            ohOrderHeaderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ohOrderHeader.label', default: 'OhOrderHeader'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
