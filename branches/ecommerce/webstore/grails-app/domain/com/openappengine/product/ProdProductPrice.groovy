package com.openappengine.product

import java.math.BigDecimal;
import java.util.Date;

class ProdProductPrice {
	
	String ppCurrencyUomId
	Date ppFromDate
	BigDecimal ppPrice = 0
	Date ppToDate
	
	static belogsTo = [prodProduct : Product]

    static constraints = {
    }
}
