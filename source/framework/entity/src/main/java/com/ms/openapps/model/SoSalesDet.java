package com.ms.openapps.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the so_sales_det database table.
 * 
 */
@Entity
@Table(name="so_sales_det")
public class SoSalesDet extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SALES_DET_ID",nullable=false)
	private int salesDetId;
	
	@Column(name="COST", precision=10, scale=2)
	private BigDecimal cost;

	@Column(name="DISCOUNT", precision=10, scale=2)
	private BigDecimal discount;

	@Column(name="LINE_NO", nullable=false)
	private int lineNo;

	@Column(name="LOCATION", nullable=true, length=255)
	private String location;

	@Column(name="LOT_NO", nullable=true, length=255)
	private String lotNo;

	@Column(name="ORD_TYPE", nullable=false, length=10)
	private String ordType;

	@Column(name="PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name="QTY_ORD", precision=10, scale=2)
	private BigDecimal qtyOrd;

	@Column(name="UOM", nullable=false, length=5)
	private String uom;

	@Column(name="WEIGHT", precision=10, scale=2)
	private BigDecimal weight;

	@Column(name="ITEM_ID", nullable=false)
	private int itemMasterId;

	//bi-directional many-to-one association to SoSalesHdr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SALES_ID", nullable=false)
	private SoSalesHdr soSalesHdr;

    public SoSalesDet() {
    }

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getLineNo() {
		return this.lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLotNo() {
		return this.lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getOrdType() {
		return this.ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQtyOrd() {
		return this.qtyOrd;
	}

	public void setQtyOrd(BigDecimal qtyOrd) {
		this.qtyOrd = qtyOrd;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public SoSalesHdr getSoSalesHdr() {
		return this.soSalesHdr;
	}

	public void setSoSalesHdr(SoSalesHdr soSalesHdr) {
		this.soSalesHdr = soSalesHdr;
	}

	public int getSalesDetId() {
		return salesDetId;
	}

	public void setSalesDetId(int salesDetId) {
		this.salesDetId = salesDetId;
	}

	public int getItemMasterId() {
		return itemMasterId;
	}

	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	
}