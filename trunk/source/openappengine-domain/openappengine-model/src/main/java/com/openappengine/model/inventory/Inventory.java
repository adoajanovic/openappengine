package com.openappengine.model.inventory;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.model.entity.Entity;

@javax.persistence.Entity
@Table(name="IN_INVENTORY_MASTER")
public class Inventory implements Entity<Inventory, Integer> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IM_INVENTORY_MASTER_ID")
	private int inventoryId;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="IM_DATE_LR")
	private Date dateLr;

	@Column(name="IM_ITEM_ID")
	private int itemId;

	@Column(name="IM_LOCATION")
	private String location;

	@Column(name="IM_LOT_NO")
	private String lotNo;

	@Column(name="IM_QTY_AV")
	private BigDecimal qtyAv;

	@Column(name="IM_QTY_CM")
	private BigDecimal qtyCm;

	@Column(name="IM_QTY_PO")
	private BigDecimal qtyPo;

	@Column(name="IM_STATUS")
	private String status;

	@Column(name="IM_UOM")
	private String uom;

    public Inventory() {
    }

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Date getDateLr() {
		return dateLr;
	}

	public void setDateLr(Date dateLr) {
		this.dateLr = dateLr;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public BigDecimal getQtyAv() {
		return qtyAv;
	}

	public void setQtyAv(BigDecimal qtyAv) {
		this.qtyAv = qtyAv;
	}

	public BigDecimal getQtyCm() {
		return qtyCm;
	}

	public void setQtyCm(BigDecimal qtyCm) {
		this.qtyCm = qtyCm;
	}

	public BigDecimal getQtyPo() {
		return qtyPo;
	}

	public void setQtyPo(BigDecimal qtyPo) {
		this.qtyPo = qtyPo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
	
	public void doNothing(){}

	public boolean sameIdentityAs(Inventory other) {
		return false;
	}

	public Integer identity() {
		return inventoryId;
	}
}