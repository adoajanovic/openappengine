package com.openappengine.model.product

import org.apache.commons.lang.StringUtils
import org.springframework.dao.DataIntegrityViolationException

import com.openappengine.model.common.Image

class ProdGemstoneController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 9, 9)
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
		redirect(action:"upload",id: prodGemstoneInstance.pdProductId)
    }
	
	def upload = {
		
	}
	
	def uploadImage = {
		def webRootDir = servletContext.getRealPath("/")
		def userDir = new File(webRootDir, "/images/uploads/product")
			
		//TODO
		//userDir = new File("c:\\temp")
		
		//handle uploaded file
		def uploadedFileThumbnail = request.getFile('payloadThumbnailImg')
		if(!uploadedFileThumbnail.empty){
			println "Class: ${uploadedFileThumbnail.class}"
			println "Name: ${uploadedFileThumbnail.name}"
			println "OriginalFileName: ${uploadedFileThumbnail.originalFilename}"
			println "Size: ${uploadedFileThumbnail.size}"
			println "ContentType: ${uploadedFileThumbnail.contentType}"
			
			
			if(params.productId) {
				Product p = Product.get(params.productId)

				if(p) {
					def prefix = ""
					prefix = "THUMB"

					def image = new Image(params)
					image.fromDate = new Date()
					image.imageUrl = prefix + "_" + p.pdProductId + "_" + uploadedFileThumbnail.originalFilename
					
					uploadedFileThumbnail.transferTo( new File( userDir, image.imageUrl))
					
					image.save(flush:true)

					p.smallImage = image
				}
			}
		}

		def uploadedFileDetail = request.getFile('payloadDetailImg')
		if(!uploadedFileDetail.empty){
			println "Class: ${uploadedFileDetail.class}"
			println "Name: ${uploadedFileDetail.name}"
			println "OriginalFileName: ${uploadedFileDetail.originalFilename}"
			println "Size: ${uploadedFileDetail.size}"
			println "ContentType: ${uploadedFileDetail.contentType}"

			if(params.productId) {
				Product p = Product.get(params.productId)

				if(p) {
					def prefix = ""
					prefix = "DET"

					def image = new Image(params)
					image.fromDate = new Date()
					image.imageUrl = prefix + p.pdProductId + "_" + uploadedFileDetail.originalFilename
					
					uploadedFileDetail.transferTo( new File( userDir, uploadedFileDetail.originalFilename))
					
					image.save(flush:true)

					p.detailImage = image
				}
			}
		}
		
		redirect(action: "list")
	}
	
	def showImage  = {
		
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
