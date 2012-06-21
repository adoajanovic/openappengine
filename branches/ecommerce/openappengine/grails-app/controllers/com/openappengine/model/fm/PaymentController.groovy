package com.openappengine.model.fm

import org.springframework.dao.DataIntegrityViolationException

class PaymentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fmPaymentInstanceList: Payment.list(params), fmPaymentInstanceTotal: Payment.count()]
    }

    def create() {
        [fmPaymentInstance: new Payment(params)]
    }

    def save() {
        def fmPaymentInstance = new Payment(params)
        if (!fmPaymentInstance.save(flush: true)) {
            render(view: "create", model: [fmPaymentInstance: fmPaymentInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), fmPaymentInstance.id])
        redirect(action: "show", id: fmPaymentInstance.id)
    }

    def show() {
        def fmPaymentInstance = Payment.get(params.id)
        if (!fmPaymentInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "list")
            return
        }

        [fmPaymentInstance: fmPaymentInstance]
    }

    def edit() {
        def fmPaymentInstance = Payment.get(params.id)
        if (!fmPaymentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "list")
            return
        }

        [fmPaymentInstance: fmPaymentInstance]
    }

    def update() {
        def fmPaymentInstance = Payment.get(params.id)
        if (!fmPaymentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fmPaymentInstance.version > version) {
                fmPaymentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'fmPayment.label', default: 'FmPayment')] as Object[],
                          "Another user has updated this FmPayment while you were editing")
                render(view: "edit", model: [fmPaymentInstance: fmPaymentInstance])
                return
            }
        }

        fmPaymentInstance.properties = params

        if (!fmPaymentInstance.save(flush: true)) {
            render(view: "edit", model: [fmPaymentInstance: fmPaymentInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), fmPaymentInstance.id])
        redirect(action: "show", id: fmPaymentInstance.id)
    }

    def delete() {
        def fmPaymentInstance = Payment.get(params.id)
        if (!fmPaymentInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fmPaymentInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fmPayment.label', default: 'FmPayment'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
