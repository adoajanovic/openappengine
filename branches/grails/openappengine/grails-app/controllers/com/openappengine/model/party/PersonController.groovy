package com.openappengine.model.party

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

class PersonController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def partyService
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [personInstanceList: Person.list(params), personInstanceTotal: Person.count()]
    }
	
	def listJSON = {
		def contacts = Person.list (params)
		def totalRows = Person.count()
		
		def results = contacts?.collect {
			[
			 "id" : it.partyId,	
			 "firstName" : it.firstName,
			 "lastName" : it.lastName,
			 "externalId" : it.externalId,
			 "status" : it.status
			]
		}
		
		render results as JSON
	}

    def create() {
        [personInstance: new Person(params),addressInstance: new Address(params)]
    }
	
	def createAddress() {
		[addressInstance: new Address(params)]
		render(view: "create")
	}
	
	def addAddress() {
		def addressInstance = new Address(params)
	}

    def save() {
        def personInstance = new Person(params)
		personInstance.partyType = "PERSON"
		
		def addressInstance = new Address(params)
		personInstance.addAddress(addressInstance);
        		
		partyService.createPersonParty(personInstance)

		flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), personInstance.partyId])
        redirect(action: "show", id: personInstance.partyId)
    }

    def show() {
		String externalId = params.id
		if(externalId != null) { 
			def personInstance = Person.findByExternalId(externalId)
			
			if (!personInstance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
				redirect(action: "list")
				return
			}
			[personInstance: personInstance]
		}
    }

    def edit() {
        def personInstance = Person.get(params.id)
        if (!personInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
            return
        }

        [personInstance: personInstance]
    }

    def update() {
        def personInstance = Person.get(params.id)
        if (!personInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (personInstance.version > version) {
                personInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'person.label', default: 'Person')] as Object[],
                          "Another user has updated this Person while you were editing")
                render(view: "edit", model: [personInstance: personInstance])
                return
            }
        }

        personInstance.properties = params

        if (!personInstance.save(flush: true)) {
            render(view: "edit", model: [personInstance: personInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), personInstance.partyId])
        redirect(action: "show", id: personInstance.partyId)
    }

    def delete() {
        def personInstance = Person.get(params.id)
        if (!personInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
            return
        }

        try {
            personInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
