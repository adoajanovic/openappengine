

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the co_code_type database table.
 * 
 */
@Entity
@Table(name="co_code_type")
public class CoCodeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CT_CODE_TYPE_ID")
	private int ctCodeTypeId;

	@Column(name="CT_CODE_TYPE_VALUE")
	private String ctCodeTypeValue;

	//bi-directional many-to-one association to CoCodeMaster
	@OneToMany(mappedBy="coCodeType")
	private Set<CoCodeMaster> coCodeMasters;

    public CoCodeType() {
    }

	public int getCtCodeTypeId() {
		return this.ctCodeTypeId;
	}

	public void setCtCodeTypeId(int ctCodeTypeId) {
		this.ctCodeTypeId = ctCodeTypeId;
	}

	public String getCtCodeTypeValue() {
		return this.ctCodeTypeValue;
	}

	public void setCtCodeTypeValue(String ctCodeTypeValue) {
		this.ctCodeTypeValue = ctCodeTypeValue;
	}

	public Set<CoCodeMaster> getCoCodeMasters() {
		return this.coCodeMasters;
	}

	public void setCoCodeMasters(Set<CoCodeMaster> coCodeMasters) {
		this.coCodeMasters = coCodeMasters;
	}
	
}