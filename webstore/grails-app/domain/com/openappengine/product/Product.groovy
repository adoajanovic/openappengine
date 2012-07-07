package com.openappengine.product

import java.math.BigDecimal;
import java.util.Date;

class Product {
	
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
	
	static hasMany = [prodProductPrices : ProdProductPrice]

    static constraints = {
    }
}
