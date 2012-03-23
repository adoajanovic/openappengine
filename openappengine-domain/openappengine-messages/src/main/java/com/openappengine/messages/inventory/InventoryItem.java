/**
 * 
 */
package com.openappengine.messages.inventory;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author hrishi
 *
 */
public class InventoryItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int inventoryMasterId;

	private XMLGregorianCalendar dateLr;

	private int itemId;

	private String location;

	private String lotNo;

	private BigDecimal qtyAv;

	private BigDecimal qtyCm;

	private BigDecimal qtyPo;

	private String status;

	private String uom;

	public int getInventoryMasterId() {
		return inventoryMasterId;
	}

	public void setInventoryMasterId(int inventoryMasterId) {
		this.inventoryMasterId = inventoryMasterId;
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

	public XMLGregorianCalendar getDateLr() {
		return dateLr;
	}

	public void setDateLr(XMLGregorianCalendar dateLr) {
		this.dateLr = dateLr;
	}

}
