package com.openappengine.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.repository.model.GenericEntity;


/**
 * The persistent class for the in_inventory_master database table.
 * 
 */
@Entity
@Table(name="in_inventory_master")
public class InInventoryMaster extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IM_INVENTORY_MASTER_ID")
	private int imInventoryMasterId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IM_DATE_LR")
	private Date imDateLr;

	@Column(name="IM_ITEM_ID")
	private int imItemId;

	@Column(name="IM_LOCATION")
	private String imLocation;

	@Column(name="IM_LOT_NO")
	private String imLotNo;

	@Column(name="IM_QTY_AV")
	private BigDecimal imQtyAv;

	@Column(name="IM_QTY_CM")
	private BigDecimal imQtyCm;

	@Column(name="IM_QTY_PO")
	private BigDecimal imQtyPo;

	@Column(name="IM_STATUS")
	private String imStatus;

	@Column(name="IM_UOM")
	private String imUom;

    public InInventoryMaster() {
    }

	public int getImInventoryMasterId() {
		return this.imInventoryMasterId;
	}

	public void setImInventoryMasterId(int imInventoryMasterId) {
		this.imInventoryMasterId = imInventoryMasterId;
	}

	public Date getImDateLr() {
		return this.imDateLr;
	}

	public void setImDateLr(Date imDateLr) {
		this.imDateLr = imDateLr;
	}

	public int getImItemId() {
		return this.imItemId;
	}

	public void setImItemId(int imItemId) {
		this.imItemId = imItemId;
	}

	public String getImLocation() {
		return this.imLocation;
	}

	public void setImLocation(String imLocation) {
		this.imLocation = imLocation;
	}

	public String getImLotNo() {
		return this.imLotNo;
	}

	public void setImLotNo(String imLotNo) {
		this.imLotNo = imLotNo;
	}

	public BigDecimal getImQtyAv() {
		return this.imQtyAv;
	}

	public void setImQtyAv(BigDecimal imQtyAv) {
		this.imQtyAv = imQtyAv;
	}

	public BigDecimal getImQtyCm() {
		return this.imQtyCm;
	}

	public void setImQtyCm(BigDecimal imQtyCm) {
		this.imQtyCm = imQtyCm;
	}

	public BigDecimal getImQtyPo() {
		return this.imQtyPo;
	}

	public void setImQtyPo(BigDecimal imQtyPo) {
		this.imQtyPo = imQtyPo;
	}

	public String getImStatus() {
		return this.imStatus;
	}

	public void setImStatus(String imStatus) {
		this.imStatus = imStatus;
	}

	public String getImUom() {
		return this.imUom;
	}

	public void setImUom(String imUom) {
		this.imUom = imUom;
	}

}