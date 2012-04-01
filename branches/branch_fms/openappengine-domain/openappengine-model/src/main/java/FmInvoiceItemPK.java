

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fm_invoice_item database table.
 * 
 */
@Embeddable
public class FmInvoiceItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="IT_INVOICE_ID")
	private int itInvoiceId;

	@Column(name="IT_INVOICE_ITEM_SEQ_ID")
	private int itInvoiceItemSeqId;

    public FmInvoiceItemPK() {
    }
	public int getItInvoiceId() {
		return this.itInvoiceId;
	}
	public void setItInvoiceId(int itInvoiceId) {
		this.itInvoiceId = itInvoiceId;
	}
	public int getItInvoiceItemSeqId() {
		return this.itInvoiceItemSeqId;
	}
	public void setItInvoiceItemSeqId(int itInvoiceItemSeqId) {
		this.itInvoiceItemSeqId = itInvoiceItemSeqId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FmInvoiceItemPK)) {
			return false;
		}
		FmInvoiceItemPK castOther = (FmInvoiceItemPK)other;
		return 
			(this.itInvoiceId == castOther.itInvoiceId)
			&& (this.itInvoiceItemSeqId == castOther.itInvoiceItemSeqId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itInvoiceId;
		hash = hash * prime + this.itInvoiceItemSeqId;
		
		return hash;
    }
}