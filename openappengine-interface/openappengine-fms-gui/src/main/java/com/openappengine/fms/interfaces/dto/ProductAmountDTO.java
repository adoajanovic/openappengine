/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hrishikesh.joshi
 *
 */
public class ProductAmountDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal calculatedTax;
	
	private BigDecimal listPrice;
	
	private BigDecimal priceGross;

	public BigDecimal getCalculatedTax() {
		return calculatedTax;
	}

	public void setCalculatedTax(BigDecimal calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal priceNet) {
		this.listPrice = priceNet;
	}

	public BigDecimal getPriceGross() {
		return priceGross;
	}

	public void setPriceGross(BigDecimal priceGross) {
		this.priceGross = priceGross;
	}
}
