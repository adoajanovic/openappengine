

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the co_code_master database table.
 * 
 */
@Entity
@Table(name="co_code_master")
public class CoCodeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CM_CODE_MASTER_ID")
	private int cmCodeMasterId;

	@Column(name="CM_CODE_LABEL")
	private String cmCodeLabel;

	@Column(name="CM_CODE_VALUE")
	private String cmCodeValue;

	//bi-directional many-to-one association to CoCodeType
    @ManyToOne
	@JoinColumn(name="CM_CODE_TYPE_ID")
	private CoCodeType coCodeType;

    public CoCodeMaster() {
    }

	public int getCmCodeMasterId() {
		return this.cmCodeMasterId;
	}

	public void setCmCodeMasterId(int cmCodeMasterId) {
		this.cmCodeMasterId = cmCodeMasterId;
	}

	public String getCmCodeLabel() {
		return this.cmCodeLabel;
	}

	public void setCmCodeLabel(String cmCodeLabel) {
		this.cmCodeLabel = cmCodeLabel;
	}

	public String getCmCodeValue() {
		return this.cmCodeValue;
	}

	public void setCmCodeValue(String cmCodeValue) {
		this.cmCodeValue = cmCodeValue;
	}

	public CoCodeType getCoCodeType() {
		return this.coCodeType;
	}

	public void setCoCodeType(CoCodeType coCodeType) {
		this.coCodeType = coCodeType;
	}
	
}