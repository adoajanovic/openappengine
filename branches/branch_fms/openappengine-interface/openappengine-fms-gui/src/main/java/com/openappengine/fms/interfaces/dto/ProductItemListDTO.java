package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class ProductItemListDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int productId;
	
	private String productName;
	
	private BigDecimal netPrice;
	
	private BigDecimal taxPrice;
	
	private BigDecimal totalProductPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return StringUtils.capitalize(productName) + " [" + productId +"]";
	}

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getTotalProductPrice() {
		return totalProductPrice;
	}

	public void setTotalProductPrice(BigDecimal totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	
}
