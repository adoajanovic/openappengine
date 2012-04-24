package com.openappengine.model.fm;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the fm_invoice_item database table.
 * 
 */
@Entity
@Table(name="fm_invoice_item")
public class FmInvoiceItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FmInvoiceItemPK id;

	@Column(name="IT_AMOUNT", precision=10, scale=3)
	private BigDecimal itAmount;

	@Column(name="IT_DESCRIPTION", length=255)
	private String itDescription;

	@Column(name="IT_INVENTORY_ITEM_ID")
	private int itInventoryItemId;

	@Column(name="IT_INVOICE_ITEM_TYPE_ID")
	private String itInvoiceItemTypeId;

	@Column(name="IT_OVERRIDE_GL_ACCOUNT_ID")
	private int itOverrideGlAccountId;

	@Column(name="IT_OVERRIDE_ORG_PARTY_ID")
	private int itOverrideOrgPartyId;

	@Column(name="IT_PARENT_INVOICE_ID")
	private int itParentInvoiceId;

	@Column(name="IT_PARENT_INVOICE_ITEM_SEQ_ID", length=20)
	private String itParentInvoiceItemSeqId;

	@Column(name="IT_PRODUCT_FEATURE_ID", length=20)
	private String itProductFeatureId;

	@Column(name="IT_PRODUCT_ID")
	private int itProductId;

	@Column(name="IT_QUANTITY", precision=10, scale=6)
	private BigDecimal itQuantity;

	@Column(name="IT_SALES_OPPORTUNITY_ID", length=20)
	private String itSalesOpportunityId;

	@Column(name="IT_TAX_AUTH_GEO_ID", length=20)
	private String itTaxAuthGeoId;

	@Column(name="IT_TAX_AUTH_PARTY_ID", length=20)
	private String itTaxAuthPartyId;

	@Column(name="IT_TAX_AUTHORITY_RATE_SEQ_ID", length=20)
	private String itTaxAuthorityRateSeqId;

	@Column(name="IT_TAXABLE_FLAG")
	private boolean itTaxableFlag;

	@Column(name="IT_UOM_ID", length=20)
	private String itUomId;

	//bi-directional many-to-one association to FmInvoice
    @ManyToOne
	@JoinColumn(name="IT_INVOICE_ID", nullable=false, insertable=false, updatable=false)
	private FmInvoice fmInvoice;

    public FmInvoiceItem() {
    }

	public FmInvoiceItemPK getId() {
		return this.id;
	}

	public void setId(FmInvoiceItemPK id) {
		this.id = id;
	}
	
	public BigDecimal getItAmount() {
		return this.itAmount;
	}

	public void setItAmount(BigDecimal itAmount) {
		this.itAmount = itAmount;
	}

	public String getItDescription() {
		return this.itDescription;
	}

	public void setItDescription(String itDescription) {
		this.itDescription = itDescription;
	}

	public int getItInventoryItemId() {
		return this.itInventoryItemId;
	}

	public void setItInventoryItemId(int itInventoryItemId) {
		this.itInventoryItemId = itInventoryItemId;
	}

	public String getItInvoiceItemTypeId() {
		return this.itInvoiceItemTypeId;
	}

	public void setItInvoiceItemTypeId(String itInvoiceItemTypeId) {
		this.itInvoiceItemTypeId = itInvoiceItemTypeId;
	}

	public int getItOverrideGlAccountId() {
		return this.itOverrideGlAccountId;
	}

	public void setItOverrideGlAccountId(int itOverrideGlAccountId) {
		this.itOverrideGlAccountId = itOverrideGlAccountId;
	}

	public int getItOverrideOrgPartyId() {
		return this.itOverrideOrgPartyId;
	}

	public void setItOverrideOrgPartyId(int itOverrideOrgPartyId) {
		this.itOverrideOrgPartyId = itOverrideOrgPartyId;
	}

	public int getItParentInvoiceId() {
		return this.itParentInvoiceId;
	}

	public void setItParentInvoiceId(int itParentInvoiceId) {
		this.itParentInvoiceId = itParentInvoiceId;
	}

	public String getItParentInvoiceItemSeqId() {
		return this.itParentInvoiceItemSeqId;
	}

	public void setItParentInvoiceItemSeqId(String itParentInvoiceItemSeqId) {
		this.itParentInvoiceItemSeqId = itParentInvoiceItemSeqId;
	}

	public String getItProductFeatureId() {
		return this.itProductFeatureId;
	}

	public void setItProductFeatureId(String itProductFeatureId) {
		this.itProductFeatureId = itProductFeatureId;
	}

	public int getItProductId() {
		return this.itProductId;
	}

	public void setItProductId(int itProductId) {
		this.itProductId = itProductId;
	}

	public BigDecimal getItQuantity() {
		return this.itQuantity;
	}

	public void setItQuantity(BigDecimal itQuantity) {
		this.itQuantity = itQuantity;
	}

	public String getItSalesOpportunityId() {
		return this.itSalesOpportunityId;
	}

	public void setItSalesOpportunityId(String itSalesOpportunityId) {
		this.itSalesOpportunityId = itSalesOpportunityId;
	}

	public String getItTaxAuthGeoId() {
		return this.itTaxAuthGeoId;
	}

	public void setItTaxAuthGeoId(String itTaxAuthGeoId) {
		this.itTaxAuthGeoId = itTaxAuthGeoId;
	}

	public String getItTaxAuthPartyId() {
		return this.itTaxAuthPartyId;
	}

	public void setItTaxAuthPartyId(String itTaxAuthPartyId) {
		this.itTaxAuthPartyId = itTaxAuthPartyId;
	}

	public String getItTaxAuthorityRateSeqId() {
		return this.itTaxAuthorityRateSeqId;
	}

	public void setItTaxAuthorityRateSeqId(String itTaxAuthorityRateSeqId) {
		this.itTaxAuthorityRateSeqId = itTaxAuthorityRateSeqId;
	}

	public boolean isItTaxableFlag() {
		return this.itTaxableFlag;
	}

	public void setItTaxableFlag(boolean itTaxableFlag) {
		this.itTaxableFlag = itTaxableFlag;
	}

	public String getItUomId() {
		return this.itUomId;
	}

	public void setItUomId(String itUomId) {
		this.itUomId = itUomId;
	}

	public FmInvoice getFmInvoice() {
		return this.fmInvoice;
	}

	public void setFmInvoice(FmInvoice fmInvoice) {
		this.fmInvoice = fmInvoice;
	}
	
}