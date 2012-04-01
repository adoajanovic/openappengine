

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ab_role database table.
 * 
 */
@Entity
@Table(name="ab_role")
public class AbRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="AB_ADDRESS_ROLE_ID")
	private int abAddressRoleId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="AB_ROLE_FROM_DATE")
	private Date abRoleFromDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="AB_ROLE_TO_DATE")
	private Date abRoleToDate;

	@Column(name="AB_ROLE_VALUE")
	private String abRoleValue;

    public AbRole() {
    }

	public int getAbAddressRoleId() {
		return this.abAddressRoleId;
	}

	public void setAbAddressRoleId(int abAddressRoleId) {
		this.abAddressRoleId = abAddressRoleId;
	}

	public Date getAbRoleFromDate() {
		return this.abRoleFromDate;
	}

	public void setAbRoleFromDate(Date abRoleFromDate) {
		this.abRoleFromDate = abRoleFromDate;
	}

	public Date getAbRoleToDate() {
		return this.abRoleToDate;
	}

	public void setAbRoleToDate(Date abRoleToDate) {
		this.abRoleToDate = abRoleToDate;
	}

	public String getAbRoleValue() {
		return this.abRoleValue;
	}

	public void setAbRoleValue(String abRoleValue) {
		this.abRoleValue = abRoleValue;
	}

}