package com.openappengine.model.salesorder;

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

import com.openappengine.model.valueobject.ValueObject;

@Entity
@Table(name="SO_SALES_DET")
public class SalesDet implements ValueObject<SalesDet> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SO_DET_ID",nullable=false)
	private int salesDetId;
	
	@Column(name="SO_COST", precision=10, scale=2)
	private BigDecimal cost;

	@Column(name="SO_DISCOUNT", precision=10, scale=2)
	private BigDecimal discount;

	@Column(name="SO_LINE_NO", nullable=false)
	private int lineNo;

	@Column(name="SO_LOCATION", nullable=true, length=255)
	private String location;

	@Column(name="SO_LOT_NO", nullable=true, length=255)
	private String lotNo;

	@Column(name="SO_ORD_TYPE", nullable=false, length=50)
	private String ordType;

	@Column(name="SO_PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name="SO_QTY_ORD", precision=10, scale=2)
	private BigDecimal qtyOrd;

	@Column(name="SO_UOM", nullable=false, length=50)
	private String uom;

	@Column(name="SO_WEIGHT", precision=10, scale=2)
	private BigDecimal weight;

	@Column(name="SO_ITEM_ID", nullable=false)
	private int itemId;

	//bi-directional many-to-one association to SoSalesHdr
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SO_SALES_ID", nullable=false)
	private SalesHdr salesHdr;
	
    public SalesDet() {
    }

	public int getSalesDetId() {
		return salesDetId;
	}

	public void setSalesDetId(int salesDetId) {
		this.salesDetId = salesDetId;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
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

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public boolean sameValueAs(SalesDet other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + getItemId();
		result = prime * result + lineNo;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((lotNo == null) ? 0 : lotNo.hashCode());
		result = prime * result + ((ordType == null) ? 0 : ordType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((qtyOrd == null) ? 0 : qtyOrd.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesDet other = (SalesDet) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (getItemId() != other.getItemId())
			return false;
		if (lineNo != other.lineNo)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (lotNo == null) {
			if (other.lotNo != null)
				return false;
		} else if (!lotNo.equals(other.lotNo))
			return false;
		if (ordType == null) {
			if (other.ordType != null)
				return false;
		} else if (!ordType.equals(other.ordType))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qtyOrd == null) {
			if (other.qtyOrd != null)
				return false;
		} else if (!qtyOrd.equals(other.qtyOrd))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	public SalesHdr getSalesHdr() {
		return salesHdr;
	}

	public void setSalesHdr(SalesHdr salesHdr) {
		this.salesHdr = salesHdr;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}