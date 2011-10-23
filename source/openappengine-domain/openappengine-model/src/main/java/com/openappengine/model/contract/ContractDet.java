package com.openappengine.model.contract;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CN_CONTRACT_DET")
public class ContractDet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CN_CONTRACT_DET_ID", unique=true, nullable=false)
	private int contractDetId;

	@Column(name="CN_COST", precision=10, scale=2)
	private BigDecimal cost;

	@Column(name="CN_DISCOUNT", precision=10, scale=2)
	private BigDecimal discount;

	@Column(name="CN_ITEM_ID", nullable=false)
	private int itemId;

	@Column(name="CN_LOCATION", length=255)
	private String location;

	@Column(name="CN_LOT_NO", length=255)
	private String lotNo;

	@Column(name="CN_ORD_TYPE", nullable=false, length=10)
	private String ordType;

	@Column(name="CN_PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name="CN_QTY_ORD", precision=10, scale=2)
	private BigDecimal qtyOrd;

	@Column(name="CN_UOM", nullable=false, length=5)
	private String uom;

	@Column(name="CN_WEIGHT", precision=10, scale=2)
	private BigDecimal weight;

	//bi-directional many-to-one association to ContractHdr
    @ManyToOne
	@JoinColumn(name="CN_CONTRACT_ID", nullable=false)
	private ContractHdr contractHdr;

	public ContractDet() {
	}

	public int getContractDetId() {
		return contractDetId;
	}

	public void setContractDetId(int contractDetId) {
		this.contractDetId = contractDetId;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
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

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQtyOrd() {
		return qtyOrd;
	}

	public void setQtyOrd(BigDecimal qtyOrd) {
		this.qtyOrd = qtyOrd;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public ContractHdr getContractHdr() {
		return contractHdr;
	}

	public void setContractHdr(ContractHdr contractHdr) {
		this.contractHdr = contractHdr;
	}
	
}