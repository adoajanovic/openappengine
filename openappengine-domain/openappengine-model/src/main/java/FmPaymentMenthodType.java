

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fm_payment_menthod_type database table.
 * 
 */
@Entity
@Table(name="fm_payment_menthod_type")
public class FmPaymentMenthodType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="PM_PAYMENT_METHOD_TYPE_ID")
	private int pmPaymentMethodTypeId;

	@Column(name="PM_HAS_TABLE")
	private String pmHasTable;

	@Column(name="PM_PAYMENT_METHOD_TYPE_DESC")
	private String pmPaymentMethodTypeDesc;

	@Column(name="PM_TABLE_NAME")
	private String pmTableName;

	//bi-directional many-to-one association to FmPayment
	@OneToMany(mappedBy="fmPaymentMenthodType")
	private Set<FmPayment> fmPayments;

    public FmPaymentMenthodType() {
    }

	public int getPmPaymentMethodTypeId() {
		return this.pmPaymentMethodTypeId;
	}

	public void setPmPaymentMethodTypeId(int pmPaymentMethodTypeId) {
		this.pmPaymentMethodTypeId = pmPaymentMethodTypeId;
	}

	public String getPmHasTable() {
		return this.pmHasTable;
	}

	public void setPmHasTable(String pmHasTable) {
		this.pmHasTable = pmHasTable;
	}

	public String getPmPaymentMethodTypeDesc() {
		return this.pmPaymentMethodTypeDesc;
	}

	public void setPmPaymentMethodTypeDesc(String pmPaymentMethodTypeDesc) {
		this.pmPaymentMethodTypeDesc = pmPaymentMethodTypeDesc;
	}

	public String getPmTableName() {
		return this.pmTableName;
	}

	public void setPmTableName(String pmTableName) {
		this.pmTableName = pmTableName;
	}

	public Set<FmPayment> getFmPayments() {
		return this.fmPayments;
	}

	public void setFmPayments(Set<FmPayment> fmPayments) {
		this.fmPayments = fmPayments;
	}
	
}