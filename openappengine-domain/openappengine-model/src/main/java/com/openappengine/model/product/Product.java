package com.openappengine.model.product;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.model.fm.FmTaxRateProduct;


/**
 * The persistent class for the prod_product database table.
 * 
 */
@Entity
@Table(name="prod_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="addressGenerator")  
	@TableGenerator(name="addressGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="PD_PRODUCT_ID")
	private int pdProductId;

	@Column(name="PD_AMOUNT_UOM_TYPE_ID")
	private String pdAmountUomTypeId;

	@Column(name="PD_COMMENTS")
	private String pdComments;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PD_CREATED_DATE")
	private Date pdCreatedDate;

	@Column(name="PD_DESCRIPTION")
	private String pdDescription;

	@Column(name="PD_FIXED_AMOUNT")
	private BigDecimal pdFixedAmount;

	@Column(name="PD_INTERNAL_NAME")
	private String pdInternalName;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PD_INTRODUCTION_DATE")
	private Date pdIntroductionDate;

	@Column(name="PD_IS_VIRTUAL")
	private boolean pdIsVirtual;

	@Column(name="PD_PIECES_INCLUDED")
	private BigDecimal pdPiecesIncluded;

	@Column(name="PD_PRODUCT_NAME")
	private String pdProductName;

	@Column(name="PD_QUANTITY_INCLUDED")
	private BigDecimal pdQuantityIncluded;

	@Column(name="PD_QUANTITY_UOM_ID")
	private String pdQuantityUomId;

	@Column(name="PD_REQUIRE_AMOUNT")
	private boolean pdRequireAmount;

	@Column(name="PD_REQUIRE_INVENTORY")
	private boolean pdRequireInventory;

	@Column(name="PD_RETURNABLE")
	private boolean pdReturnable;

	@Column(name="PD_SALES_DISC_WHEN_NOT_AVAIL")
	private boolean pdSalesDiscWhenNotAvail;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PD_SALES_DISCONTINUATION_DATE")
	private Date pdSalesDiscontinuationDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PD_SUPPORT_DISCONTINUATION_DATE")
	private Date pdSupportDiscontinuationDate;

	@Column(name="PD_TAXABLE")
	private boolean pdTaxable;

	@Column(name="PD_WEIGHT")
	private BigDecimal pdWeight;

	@Column(name="PD_WEIGHT_UOM_ID")
	private String pdWeightUomId;

	//bi-directional many-to-one association to FmsFleetTaskUser
	/*@OneToMany(mappedBy="prodProduct")
	private Set<FmsFleetTaskUser> fmsFleetTaskUsers;*/
	
	@OneToMany(mappedBy="product")
	private List<FmTaxRateProduct> taxRates;

	//bi-directional many-to-one association to ProdProductType
    @ManyToOne
	@JoinColumn(name="PD_PRODUCT_TYPE_ID")
	private ProdProductType prodProductType;

    public Product() {
    }

	public int getPdProductId() {
		return this.pdProductId;
	}

	public void setPdProductId(int pdProductId) {
		this.pdProductId = pdProductId;
	}

	public String getPdAmountUomTypeId() {
		return this.pdAmountUomTypeId;
	}

	public void setPdAmountUomTypeId(String pdAmountUomTypeId) {
		this.pdAmountUomTypeId = pdAmountUomTypeId;
	}

	public String getPdComments() {
		return this.pdComments;
	}

	public void setPdComments(String pdComments) {
		this.pdComments = pdComments;
	}

	public Date getPdCreatedDate() {
		return this.pdCreatedDate;
	}

	public void setPdCreatedDate(Date pdCreatedDate) {
		this.pdCreatedDate = pdCreatedDate;
	}

	public String getPdDescription() {
		return this.pdDescription;
	}

	public void setPdDescription(String pdDescription) {
		this.pdDescription = pdDescription;
	}

	public BigDecimal getPdFixedAmount() {
		return this.pdFixedAmount;
	}

	public void setPdFixedAmount(BigDecimal pdFixedAmount) {
		this.pdFixedAmount = pdFixedAmount;
	}

	public String getPdInternalName() {
		return this.pdInternalName;
	}

	public void setPdInternalName(String pdInternalName) {
		this.pdInternalName = pdInternalName;
	}

	public Date getPdIntroductionDate() {
		return this.pdIntroductionDate;
	}

	public void setPdIntroductionDate(Date pdIntroductionDate) {
		this.pdIntroductionDate = pdIntroductionDate;
	}

	public boolean getPdIsVirtual() {
		return this.pdIsVirtual;
	}

	public void setPdIsVirtual(boolean pdIsVirtual) {
		this.pdIsVirtual = pdIsVirtual;
	}

	public BigDecimal getPdPiecesIncluded() {
		return this.pdPiecesIncluded;
	}

	public void setPdPiecesIncluded(BigDecimal pdPiecesIncluded) {
		this.pdPiecesIncluded = pdPiecesIncluded;
	}

	public String getPdProductName() {
		return this.pdProductName;
	}

	public void setPdProductName(String pdProductName) {
		this.pdProductName = pdProductName;
	}

	public BigDecimal getPdQuantityIncluded() {
		return this.pdQuantityIncluded;
	}

	public void setPdQuantityIncluded(BigDecimal pdQuantityIncluded) {
		this.pdQuantityIncluded = pdQuantityIncluded;
	}

	public String getPdQuantityUomId() {
		return this.pdQuantityUomId;
	}

	public void setPdQuantityUomId(String pdQuantityUomId) {
		this.pdQuantityUomId = pdQuantityUomId;
	}

	public boolean getPdRequireAmount() {
		return this.pdRequireAmount;
	}

	public void setPdRequireAmount(boolean pdRequireAmount) {
		this.pdRequireAmount = pdRequireAmount;
	}

	public boolean getPdRequireInventory() {
		return this.pdRequireInventory;
	}

	public void setPdRequireInventory(boolean pdRequireInventory) {
		this.pdRequireInventory = pdRequireInventory;
	}

	public boolean getPdReturnable() {
		return this.pdReturnable;
	}

	public void setPdReturnable(boolean pdReturnable) {
		this.pdReturnable = pdReturnable;
	}

	public boolean getPdSalesDiscWhenNotAvail() {
		return this.pdSalesDiscWhenNotAvail;
	}

	public void setPdSalesDiscWhenNotAvail(boolean pdSalesDiscWhenNotAvail) {
		this.pdSalesDiscWhenNotAvail = pdSalesDiscWhenNotAvail;
	}

	public Date getPdSalesDiscontinuationDate() {
		return this.pdSalesDiscontinuationDate;
	}

	public void setPdSalesDiscontinuationDate(Date pdSalesDiscontinuationDate) {
		this.pdSalesDiscontinuationDate = pdSalesDiscontinuationDate;
	}

	public Date getPdSupportDiscontinuationDate() {
		return this.pdSupportDiscontinuationDate;
	}

	public void setPdSupportDiscontinuationDate(Date pdSupportDiscontinuationDate) {
		this.pdSupportDiscontinuationDate = pdSupportDiscontinuationDate;
	}

	public boolean getPdTaxable() {
		return this.pdTaxable;
	}

	public void setPdTaxable(boolean pdTaxable) {
		this.pdTaxable = pdTaxable;
	}

	public BigDecimal getPdWeight() {
		return this.pdWeight;
	}

	public void setPdWeight(BigDecimal pdWeight) {
		this.pdWeight = pdWeight;
	}

	public String getPdWeightUomId() {
		return this.pdWeightUomId;
	}

	public void setPdWeightUomId(String pdWeightUomId) {
		this.pdWeightUomId = pdWeightUomId;
	}

	public ProdProductType getProdProductType() {
		return this.prodProductType;
	}

	public void setProdProductType(ProdProductType prodProductType) {
		this.prodProductType = prodProductType;
	}

	public List<FmTaxRateProduct> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<FmTaxRateProduct> taxRates) {
		this.taxRates = taxRates;
	}
	
}