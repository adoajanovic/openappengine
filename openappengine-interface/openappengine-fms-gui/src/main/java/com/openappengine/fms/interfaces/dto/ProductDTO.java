/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hrishi
 *
 */
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int productId;

	private String description;

	private BigDecimal fixedAmount;

	private Date introductionDate;

	private String productName;

	private Date salesDiscontinuationDate;

	private Date supportDiscontinuationDate;

	private String taxable;
	
	private String quantityUom = "PER 1 PERSON";
	
	private BigDecimal taxAmount = new BigDecimal(0.0);
	
	private BigDecimal netPrice = new BigDecimal(0.0);;
	
	private BigDecimal grossPrice = new BigDecimal(0.0);;

	private String productType;
	
	private ProductTypeDTO productTypeDTO;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getFixedAmount() {
		return fixedAmount;
	}

	public void setFixedAmount(BigDecimal fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public Date getIntroductionDate() {
		return introductionDate;
	}

	public void setIntroductionDate(Date introductionDate) {
		this.introductionDate = introductionDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getSalesDiscontinuationDate() {
		return salesDiscontinuationDate;
	}

	public void setSalesDiscontinuationDate(Date salesDiscontinuationDate) {
		this.salesDiscontinuationDate = salesDiscontinuationDate;
	}

	public Date getSupportDiscontinuationDate() {
		return supportDiscontinuationDate;
	}

	public void setSupportDiscontinuationDate(Date supportDiscontinuationDate) {
		this.supportDiscontinuationDate = supportDiscontinuationDate;
	}

	public String getTaxable() {
		return taxable;
	}

	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public ProductTypeDTO getProductTypeDTO() {
		return productTypeDTO;
	}

	public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
		this.productTypeDTO = productTypeDTO;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(BigDecimal grossPrice) {
		this.grossPrice = grossPrice;
	}

	public String getQuantityUom() {
		return quantityUom;
	}

	public void setQuantityUom(String quantityUom) {
		this.quantityUom = quantityUom;
	}

}
