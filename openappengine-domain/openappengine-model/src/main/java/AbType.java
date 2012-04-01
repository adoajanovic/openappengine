

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ab_type database table.
 * 
 */
@Entity
@Table(name="ab_type")
public class AbType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="AB_ADDRESS_TYPE_ID")
	private int abAddressTypeId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="AB_TYPE_FROM_DATE")
	private Date abTypeFromDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="AB_TYPE_TO_DATE")
	private Date abTypeToDate;

	@Column(name="AB_TYPE_VALUE")
	private String abTypeValue;

	//bi-directional many-to-many association to AbAddressBook
    @ManyToMany
	@JoinTable(
		name="ab_address_type"
		, joinColumns={
			@JoinColumn(name="AT_ADDRESS_TYPE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AT_ADDRESS_BOOK_ID")
			}
		)
	private Set<AbAddressBook> abAddressBooks;

    public AbType() {
    }

	public int getAbAddressTypeId() {
		return this.abAddressTypeId;
	}

	public void setAbAddressTypeId(int abAddressTypeId) {
		this.abAddressTypeId = abAddressTypeId;
	}

	public Date getAbTypeFromDate() {
		return this.abTypeFromDate;
	}

	public void setAbTypeFromDate(Date abTypeFromDate) {
		this.abTypeFromDate = abTypeFromDate;
	}

	public Date getAbTypeToDate() {
		return this.abTypeToDate;
	}

	public void setAbTypeToDate(Date abTypeToDate) {
		this.abTypeToDate = abTypeToDate;
	}

	public String getAbTypeValue() {
		return this.abTypeValue;
	}

	public void setAbTypeValue(String abTypeValue) {
		this.abTypeValue = abTypeValue;
	}

	public Set<AbAddressBook> getAbAddressBooks() {
		return this.abAddressBooks;
	}

	public void setAbAddressBooks(Set<AbAddressBook> abAddressBooks) {
		this.abAddressBooks = abAddressBooks;
	}
	
}