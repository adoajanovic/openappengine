package com.openappengine.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the co_code_master database table.
 * 
 */
@Entity
@Table(name="co_code_master")
public class CoCodeMaster extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CM_CODE_MASTER_ID")
	private int cmCodeMasterId;
	
	@Column(name="CM_CODE_LABEL", nullable=false, length=15)
	private String cmCodeLabel;

	@Column(name="CM_CODE_VALUE", nullable=false, length=15)
	private String cmCodeValue;

	//bi-directional many-to-one association to CoCodeType
    @ManyToOne
	@JoinColumn(name="CM_CODE_TYPE_ID", nullable=false)
	private CoCodeType coCodeType;

    public CoCodeMaster() {
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

	public int getCmCodeMasterId() {
		return cmCodeMasterId;
	}

	public void setCmCodeMasterId(int cmCodeMasterId) {
		this.cmCodeMasterId = cmCodeMasterId;
	}
	
}