package com.openappengine.product

class ProdProductPrice {
	
	Integer ppProdProductPriceId
	String ppCurrencyUomId
	Date ppFromDate
	BigDecimal ppPrice
	Date ppToDate
	
	static belongsTo = [prodProduct : Product]

    static constraints = {
    }
}
