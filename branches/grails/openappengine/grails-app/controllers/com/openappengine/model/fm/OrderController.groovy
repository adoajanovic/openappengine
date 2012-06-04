package com.openappengine.model.fm

import org.springframework.dao.DataIntegrityViolationException

import com.openappengine.model.contract.Contract;

class OrderController {
	
	def orderService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ohOrderHeaderInstanceList: OhOrderHeader.list(params), ohOrderHeaderInstanceTotal: OhOrderHeader.count()]
    }

    def create() {
        [ohOrderHeaderInstance: new OhOrderHeader(params)]
    }
	
    def save() {
        def ohOrderHeaderInstance = new OhOrderHeader(params)
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
