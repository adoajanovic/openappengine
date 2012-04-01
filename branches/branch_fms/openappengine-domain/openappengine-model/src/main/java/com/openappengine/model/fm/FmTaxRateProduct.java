/**
 * 
 */
package com.openappengine.model.fm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.model.product.ProdProduct;

/**
 * @author hrishi
 *
 */
@Entity
@Table(name="FM_TAX_RATE_PRODUCT")
public class FmTaxRateProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "TR_TAX_RATE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seqGenerator")  
	@TableGenerator(name="seqGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	private int taxRateId;
	
	@ManyToOne
	@JoinColumn(name="TR_PRODUCT_ID")
	private ProdProduct product;
	
	@ManyToOne
	@JoinColumn(name="TR_TAX_RATE_TYPE_ID")
	private FmTaxType taxType;
	
	@Column(name="TR_MIN_ITEM_PRICE")
	private BigDecimal minItemPrice;
	
	@Column(name="TR_MIN_PURCHASE")
	private BigDecimal minPurchase;
	
	@Column(name="TR_TAX_PERCENTAGE")
	private BigDecimal taxPercentage;

	@Column(name="TR_FROM_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Column(name="TR_TO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	@Lob()
	@Column(name = "TR_DESCRIPTION", length = 255)
	private String description;

	public int getTaxRateId() {
		return taxRateId;
	}

	public void setTaxRateId(int taxRateId) {
		this.taxRateId = taxRateId;
	}

	public ProdProduct getProduct() {
		return product;
	}

	public void setProduct(ProdProduct product) {
		this.product = product;
	}

	public FmTaxType getTaxType() {
		return taxType;
	}

	public void setTaxType(FmTaxType taxType) {
		this.taxType = taxType;
	}

	public BigDecimal getMinItemPrice() {
		return minItemPrice;
	}

	public void setMinItemPrice(BigDecimal minItemPrice) {
		this.minItemPrice = minItemPrice;
	}

	public BigDecimal getMinPurchase() {
		return minPurchase;
	}

	public void setMinPurchase(BigDecimal minPurchase) {
		this.minPurchase = minPurchase;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
