package com.openappengine.common

class ImageResource {
	
	int imageResourceId
	String path
	Date fromDate = new Date()
	Date toDate
	
	static mapping = {
		table "C_IMAGE_RESOURCE"
		version false
		
		id generator: 'identity',name:'imageResourceId',column:'C_IMAGE_RESOURCE_ID'
		imageResourceId column:'C_IMAGE_RESOURCE_ID'
		path column: 'C_IMAGE_RESOURCE_PATH',length:2000
		fromDate column: 'C_IMAGE_RESOURCE_FROM_DATE'
		toDate column: 'C_IMAGE_RESOURCE_TO_DATE'
	}
		
    static constraints = {
		path url: true,blank:false
		toDate nullable:true
    }
	
}
