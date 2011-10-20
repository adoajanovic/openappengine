package com.openappengine.model.inventory;

import java.io.Serializable;
import java.util.Date;

public class InventoryMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int inventoryMasterId;

	private Date dateLr;

	private int itemId;

	private String location;

	private String lotNo;

	private Double qtyAv;

	private Double qtyCm;

	private Double qtyPo;

	private String status;

	private String uom;

    public InventoryMaster() {
    }

	public int getInventoryMasterId() {
		return inventoryMasterId;
	}

	public void setInventoryMasterId(int inventoryMasterId) {
		this.inventoryMasterId = inventoryMasterId;
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

	public Double getQtyAv() {
		return qtyAv;
	}

	public void setQtyAv(Double qtyAv) {
		this.qtyAv = qtyAv;
	}

	public Double getQtyCm() {
		return qtyCm;
	}

	public void setQtyCm(Double qtyCm) {
		this.qtyCm = qtyCm;
	}

	public Double getQtyPo() {
		return qtyPo;
	}

	public void setQtyPo(Double qtyPo) {
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
    
}