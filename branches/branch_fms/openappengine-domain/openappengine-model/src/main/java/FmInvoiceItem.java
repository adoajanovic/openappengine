

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

	@Column(name="IT_AMOUNT")
	private BigDecimal itAmount;

	@Column(name="IT_DESCRIPTION")
	private String itDescription;

	@Column(name="IT_INVENTORY_ITEM_ID")
	private int itInventoryItemId;

	@Column(name="IT_INVOICE_ITEM_TYPE_ID")
	private int itInvoiceItemTypeId;

	@Column(name="IT_PRODUCT_FEATURE_ID")
	private int itProductFeatureId;

	@Column(name="IT_PRODUCT_ID")
	private int itProductId;

	@Column(name="IT_QUANTITY")
	private BigDecimal itQuantity;

	@Column(name="IT_TAXABLE_FLAG")
	private String itTaxableFlag;

	//bi-directional many-to-one association to FmInvoice
    @ManyToOne
	@JoinColumn(name="IT_INVOICE_ID")
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

	public int getItInvoiceItemTypeId() {
		return this.itInvoiceItemTypeId;
	}

	public void setItInvoiceItemTypeId(int itInvoiceItemTypeId) {
		this.itInvoiceItemTypeId = itInvoiceItemTypeId;
	}

	public int getItProductFeatureId() {
		return this.itProductFeatureId;
	}

	public void setItProductFeatureId(int itProductFeatureId) {
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

	public String getItTaxableFlag() {
		return this.itTaxableFlag;
	}

	public void setItTaxableFlag(String itTaxableFlag) {
		this.itTaxableFlag = itTaxableFlag;
	}

	public FmInvoice getFmInvoice() {
		return this.fmInvoice;
	}

	public void setFmInvoice(FmInvoice fmInvoice) {
		this.fmInvoice = fmInvoice;
	}
	
}