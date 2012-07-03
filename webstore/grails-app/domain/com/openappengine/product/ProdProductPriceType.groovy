package com.openappengine.product

class ProdProductPriceType {
	Integer ptProductPriceTypeId
	String ptDescription
	
	static hasMany = [prodProductPrices : ProdProductPrice]

    static constraints = {
    }
}
