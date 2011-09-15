package com.openappengine.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.openappengine.repository.model.GenericEntity;


/**
 * The persistent class for the co_code_type database table.
 * 
 */
@Entity
@Embeddable
@Table(name="co_code_type")
public class CoCodeType extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CT_CODE_TYPE_ID", unique=true, nullable=false)
	private int ctCodeTypeId;

	@Column(name="CT_CODE_TYPE_VALUE", nullable=false, length=15)
	private String ctCodeTypeValue;

	//bi-directional many-to-one association to CoCodeMaster
	@OneToMany(mappedBy="coCodeType")
	private List<CoCodeMaster> coCodeMasters;

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

	public List<CoCodeMaster> getCoCodeMasters() {
		return this.coCodeMasters;
	}

	public void setCoCodeMasters(List<CoCodeMaster> coCodeMasters) {
		this.coCodeMasters = coCodeMasters;
	}
	
}