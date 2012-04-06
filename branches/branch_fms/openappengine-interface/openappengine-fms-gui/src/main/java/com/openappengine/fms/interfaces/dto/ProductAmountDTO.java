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
	
	private BigDecimal priceNet;
	
	private BigDecimal priceGross;

	public BigDecimal getCalculatedTax() {
		return calculatedTax;
	}

	public void setCalculatedTax(BigDecimal calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(BigDecimal priceNet) {
		this.priceNet = priceNet;
	}

	public BigDecimal getPriceGross() {
		return priceGross;
	}

	public void setPriceGross(BigDecimal priceGross) {
		this.priceGross = priceGross;
	}
}
