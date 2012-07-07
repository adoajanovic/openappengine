package com.openappengine.product

import org.springframework.dao.DataIntegrityViolationException

class ProductGemStoneController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [productGemStoneInstanceList: ProductGemStone.list(params), productGemStoneInstanceTotal: ProductGemStone.count()]
    }

    def create() {
        [productGemStoneInstance: new ProductGemStone(params)]
    }

    def save() {
        def productGemStoneInstance = new ProductGemStone(params)
        if (!productGemStoneInstance.save(flush: true)) {
            render(view: "create", model: [productGemStoneInstance: productGemStoneInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), productGemStoneInstance.id])
        redirect(action: "show", id: productGemStoneInstance.id)
    }

    def show() {
        def productGemStoneInstance = ProductGemStone.get(params.id)
        if (!productGemStoneInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "list")
            return
        }

        [productGemStoneInstance: productGemStoneInstance]
    }

    def edit() {
        def productGemStoneInstance = ProductGemStone.get(params.id)
        if (!productGemStoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "list")
            return
        }

        [productGemStoneInstance: productGemStoneInstance]
    }

    def update() {
        def productGemStoneInstance = ProductGemStone.get(params.id)
        if (!productGemStoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (productGemStoneInstance.version > version) {
                productGemStoneInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'productGemStone.label', default: 'ProductGemStone')] as Object[],
                          "Another user has updated this ProductGemStone while you were editing")
                render(view: "edit", model: [productGemStoneInstance: productGemStoneInstance])
                return
            }
        }

        productGemStoneInstance.properties = params

        if (!productGemStoneInstance.save(flush: true)) {
            render(view: "edit", model: [productGemStoneInstance: productGemStoneInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), productGemStoneInstance.id])
        redirect(action: "show", id: productGemStoneInstance.id)
    }

    def delete() {
        def productGemStoneInstance = ProductGemStone.get(params.id)
        if (!productGemStoneInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "list")
            return
        }

        try {
            productGemStoneInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productGemStone.label', default: 'ProductGemStone'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
