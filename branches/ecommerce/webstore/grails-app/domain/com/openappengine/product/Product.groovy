package com.openappengine.product

class Product {
	
	Integer pdProductId
	String pdAmountUomType
	String pdComments
	Date pdCreatedDate
	String pdDescription
	BigDecimal pdFixedAmount
	String pdInternalName
	Date pdIntroductionDate
	Boolean pdIsVirtual
	BigDecimal pdPiecesIncluded
	String pdProductName
	BigDecimal pdQuantityIncluded
	String pdQuantityUom
	Boolean pdRequireAmount
	Boolean pdRequireInventory
	Boolean pdReturnable
	Boolean pdSalesDiscWhenNotAvail
	Date pdSalesDiscontinuationDate
	Date pdSupportDiscontinuationDate
	Boolean pdTaxable
	BigDecimal pdWeight
	String pdWeightUomId
	String pdProductType
	
	static hasMany= [prodProductPrices : ProdProductPrice]
	
	

    static constraints = {
		pdProductId unique:true
		
    }
	
	
}
