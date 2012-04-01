

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pm_person database table.
 * 
 */
@Entity
@Table(name="pm_person")
public class PmPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="PM_PARTY_ID")
	private int pmPartyId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PM_BIRTH_DATE")
	private Date pmBirthDate;

    @Lob()
	@Column(name="PM_COMMENTS")
	private String pmComments;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PM_DECEASED_DATE")
	private Date pmDeceasedDate;

	@Column(name="PM_FIRST_NAME")
	private String pmFirstName;

	@Column(name="PM_GENDER")
	private String pmGender;

	@Column(name="PM_LAST_NAME")
	private String pmLastName;

	@Column(name="PM_MARITAL_STATUS")
	private String pmMaritalStatus;

	@Column(name="PM_MIDDLE_NAME")
	private String pmMiddleName;

	@Column(name="PM_NICK_NAME")
	private String pmNickName;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PM_PASSPORT_EXPIRATION_DATE")
	private Date pmPassportExpirationDate;

	@Column(name="PM_PASSPORT_NUMBER")
	private String pmPassportNumber;

	@Column(name="PM_SALUTAION")
	private String pmSalutaion;

	@Column(name="PM_SSN")
	private String pmSsn;

	@Column(name="PM_SUFFIX")
	private String pmSuffix;

    public PmPerson() {
    }

	public int getPmPartyId() {
		return this.pmPartyId;
	}

	public void setPmPartyId(int pmPartyId) {
		this.pmPartyId = pmPartyId;
	}

	public Date getPmBirthDate() {
		return this.pmBirthDate;
	}

	public void setPmBirthDate(Date pmBirthDate) {
		this.pmBirthDate = pmBirthDate;
	}

	public String getPmComments() {
		return this.pmComments;
	}

	public void setPmComments(String pmComments) {
		this.pmComments = pmComments;
	}

	public Date getPmDeceasedDate() {
		return this.pmDeceasedDate;
	}

	public void setPmDeceasedDate(Date pmDeceasedDate) {
		this.pmDeceasedDate = pmDeceasedDate;
	}

	public String getPmFirstName() {
		return this.pmFirstName;
	}

	public void setPmFirstName(String pmFirstName) {
		this.pmFirstName = pmFirstName;
	}

	public String getPmGender() {
		return this.pmGender;
	}

	public void setPmGender(String pmGender) {
		this.pmGender = pmGender;
	}

	public String getPmLastName() {
		return this.pmLastName;
	}

	public void setPmLastName(String pmLastName) {
		this.pmLastName = pmLastName;
	}

	public String getPmMaritalStatus() {
		return this.pmMaritalStatus;
	}

	public void setPmMaritalStatus(String pmMaritalStatus) {
		this.pmMaritalStatus = pmMaritalStatus;
	}

	public String getPmMiddleName() {
		return this.pmMiddleName;
	}

	public void setPmMiddleName(String pmMiddleName) {
		this.pmMiddleName = pmMiddleName;
	}

	public String getPmNickName() {
		return this.pmNickName;
	}

	public void setPmNickName(String pmNickName) {
		this.pmNickName = pmNickName;
	}

	public Date getPmPassportExpirationDate() {
		return this.pmPassportExpirationDate;
	}

	public void setPmPassportExpirationDate(Date pmPassportExpirationDate) {
		this.pmPassportExpirationDate = pmPassportExpirationDate;
	}

	public String getPmPassportNumber() {
		return this.pmPassportNumber;
	}

	public void setPmPassportNumber(String pmPassportNumber) {
		this.pmPassportNumber = pmPassportNumber;
	}

	public String getPmSalutaion() {
		return this.pmSalutaion;
	}

	public void setPmSalutaion(String pmSalutaion) {
		this.pmSalutaion = pmSalutaion;
	}

	public String getPmSsn() {
		return this.pmSsn;
	}

	public void setPmSsn(String pmSsn) {
		this.pmSsn = pmSsn;
	}

	public String getPmSuffix() {
		return this.pmSuffix;
	}

	public void setPmSuffix(String pmSuffix) {
		this.pmSuffix = pmSuffix;
	}

}