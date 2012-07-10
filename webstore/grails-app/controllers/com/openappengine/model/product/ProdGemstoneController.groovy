package com.openappengine.model.product

import org.springframework.dao.DataIntegrityViolationException

class ProdGemstoneController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [prodGemstoneInstanceList: ProdGemstone.list(params), prodGemstoneInstanceTotal: ProdGemstone.count()]
    }

    def create() {
        [prodGemstoneInstance: new ProdGemstone(params)]
    }

    def save() {
        def prodGemstoneInstance = new ProdGemstone(params)
        if (!prodGemstoneInstance.save(flush: true)) {
            render(view: "create", model: [prodGemstoneInstance: prodGemstoneInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), prodGemstoneInstance.pdProductId])
        redirect(action: "show", id: prodGemstoneInstance.id)
    }

    def show() {
        def prodGemstoneInstance = ProdGemstone.get(params.id)
        if (!prodGemstoneInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "list")
            return
        }

        [prodGemstoneInstance: prodGemstoneInstance]
    }

    def edit() {
        def prodGemstoneInstance = ProdGemstone.get(params.id)
        if (!prodGemstoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "list")
            return
        }

        [prodGemstoneInstance: prodGemstoneInstance]
    }

    def update() {
        def prodGemstoneInstance = ProdGemstone.get(params.id)
        if (!prodGemstoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (prodGemstoneInstance.version > version) {
                prodGemstoneInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'prodGemstone.label', default: 'ProdGemstone')] as Object[],
                          "Another user has updated this ProdGemstone while you were editing")
                render(view: "edit", model: [prodGemstoneInstance: prodGemstoneInstance])
                return
            }
        }

        prodGemstoneInstance.properties = params

        if (!prodGemstoneInstance.save(flush: true)) {
            render(view: "edit", model: [prodGemstoneInstance: prodGemstoneInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), prodGemstoneInstance.id])
        redirect(action: "show", id: prodGemstoneInstance.id)
    }

    def delete() {
        def prodGemstoneInstance = ProdGemstone.get(params.id)
        if (!prodGemstoneInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "list")
            return
        }

        try {
            prodGemstoneInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'prodGemstone.label', default: 'ProdGemstone'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
