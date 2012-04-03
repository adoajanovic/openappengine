/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hrishikesh.joshi
 * @since  Apr 2, 2012
 *
 */
public class TaxDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal taxPercentage;
	
	private String taxType;

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	
}
