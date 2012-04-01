

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ab_address_book database table.
 * 
 */
@Entity
@Table(name="ab_address_book")
public class AbAddressBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="AB_ADDRESS_BOOK_ID")
	private int abAddressBookId;

	@Column(name="AB_ADDRESS_1")
	private String abAddress1;

	@Column(name="AB_ADDRESS_2")
	private String abAddress2;

	@Column(name="AB_ATTN_NAME")
	private String abAttnName;

	@Column(name="AB_CITY")
	private String abCity;

	@Column(name="AB_COUNTRY")
	private String abCountry;

	@Column(name="AB_DIRECTIONS")
	private String abDirections;

	@Column(name="AB_POSTAL_CODE")
	private String abPostalCode;

	@Column(name="AB_POSTAL_CODE_EXT")
	private String abPostalCodeExt;

	@Column(name="AB_STATE_PROVINCE")
	private String abStateProvince;

	@Column(name="AB_TO_NAME")
	private String abToName;

	//bi-directional many-to-many association to AbType
	@ManyToMany(mappedBy="abAddressBooks")
	private Set<AbType> abTypes;

    public AbAddressBook() {
    }

	public int getAbAddressBookId() {
		return this.abAddressBookId;
	}

	public void setAbAddressBookId(int abAddressBookId) {
		this.abAddressBookId = abAddressBookId;
	}

	public String getAbAddress1() {
		return this.abAddress1;
	}

	public void setAbAddress1(String abAddress1) {
		this.abAddress1 = abAddress1;
	}

	public String getAbAddress2() {
		return this.abAddress2;
	}

	public void setAbAddress2(String abAddress2) {
		this.abAddress2 = abAddress2;
	}

	public String getAbAttnName() {
		return this.abAttnName;
	}

	public void setAbAttnName(String abAttnName) {
		this.abAttnName = abAttnName;
	}

	public String getAbCity() {
		return this.abCity;
	}

	public void setAbCity(String abCity) {
		this.abCity = abCity;
	}

	public String getAbCountry() {
		return this.abCountry;
	}

	public void setAbCountry(String abCountry) {
		this.abCountry = abCountry;
	}

	public String getAbDirections() {
		return this.abDirections;
	}

	public void setAbDirections(String abDirections) {
		this.abDirections = abDirections;
	}

	public String getAbPostalCode() {
		return this.abPostalCode;
	}

	public void setAbPostalCode(String abPostalCode) {
		this.abPostalCode = abPostalCode;
	}

	public String getAbPostalCodeExt() {
		return this.abPostalCodeExt;
	}

	public void setAbPostalCodeExt(String abPostalCodeExt) {
		this.abPostalCodeExt = abPostalCodeExt;
	}

	public String getAbStateProvince() {
		return this.abStateProvince;
	}

	public void setAbStateProvince(String abStateProvince) {
		this.abStateProvince = abStateProvince;
	}

	public String getAbToName() {
		return this.abToName;
	}

	public void setAbToName(String abToName) {
		this.abToName = abToName;
	}

	public Set<AbType> getAbTypes() {
		return this.abTypes;
	}

	public void setAbTypes(Set<AbType> abTypes) {
		this.abTypes = abTypes;
	}
	
}