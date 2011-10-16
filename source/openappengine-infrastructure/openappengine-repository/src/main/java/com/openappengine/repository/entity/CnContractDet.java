package com.openappengine.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openappengine.repository.entity.GenericEntity;


/**
 * The persistent class for the cn_contract_det database table.
 * 
 */
@Entity
@Table(name="cn_contract_det")
public class CnContractDet extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CN_CONTRACT_DET_ID", unique=true, nullable=false)
	private int cnContractDetId;

	@Column(name="CN_COST", precision=10, scale=2)
	private BigDecimal cnCost;

	@Column(name="CN_DISCOUNT", precision=10, scale=2)
	private BigDecimal cnDiscount;

	@Column(name="CN_ITEM_ID", nullable=false)
	private int cnItemId;

	@Column(name="CN_LOCATION", length=255)
	private String cnLocation;

	@Column(name="CN_LOT_NO", length=255)
	private String cnLotNo;

	@Column(name="CN_ORD_TYPE", nullable=false, length=10)
	private String cnOrdType;

	@Column(name="CN_PRICE", precision=10, scale=2)
	private BigDecimal cnPrice;

	@Column(name="CN_QTY_ORD", precision=10, scale=2)
	private BigDecimal cnQtyOrd;

	@Column(name="CN_UOM", nullable=false, length=5)
	private String cnUom;

	@Column(name="CN_WEIGHT", precision=10, scale=2)
	private BigDecimal cnWeight;

	//bi-directional many-to-one association to CnContractHdr
    @ManyToOne
	@JoinColumn(name="CN_CONTRACT_ID", nullable=false)
	private CnContractHdr cnContractHdr;

    public CnContractDet() {
    }

	public int getCnContractDetId() {
		return this.cnContractDetId;
	}

	public void setCnContractDetId(int cnContractDetId) {
		this.cnContractDetId = cnContractDetId;
	}

	public BigDecimal getCnCost() {
		return this.cnCost;
	}

	public void setCnCost(BigDecimal cnCost) {
		this.cnCost = cnCost;
	}

	public BigDecimal getCnDiscount() {
		return this.cnDiscount;
	}

	public void setCnDiscount(BigDecimal cnDiscount) {
		this.cnDiscount = cnDiscount;
	}

	public int getCnItemId() {
		return this.cnItemId;
	}

	public void setCnItemId(int cnItemId) {
		this.cnItemId = cnItemId;
	}

	public String getCnLocation() {
		return this.cnLocation;
	}

	public void setCnLocation(String cnLocation) {
		this.cnLocation = cnLocation;
	}

	public String getCnLotNo() {
		return this.cnLotNo;
	}

	public void setCnLotNo(String cnLotNo) {
		this.cnLotNo = cnLotNo;
	}

	public String getCnOrdType() {
		return this.cnOrdType;
	}

	public void setCnOrdType(String cnOrdType) {
		this.cnOrdType = cnOrdType;
	}

	public BigDecimal getCnPrice() {
		return this.cnPrice;
	}

	public void setCnPrice(BigDecimal cnPrice) {
		this.cnPrice = cnPrice;
	}

	public BigDecimal getCnQtyOrd() {
		return this.cnQtyOrd;
	}

	public void setCnQtyOrd(BigDecimal cnQtyOrd) {
		this.cnQtyOrd = cnQtyOrd;
	}

	public String getCnUom() {
		return this.cnUom;
	}

	public void setCnUom(String cnUom) {
		this.cnUom = cnUom;
	}

	public BigDecimal getCnWeight() {
		return this.cnWeight;
	}

	public void setCnWeight(BigDecimal cnWeight) {
		this.cnWeight = cnWeight;
	}

	public CnContractHdr getCnContractHdr() {
		return this.cnContractHdr;
	}

	public void setCnContractHdr(CnContractHdr cnContractHdr) {
		this.cnContractHdr = cnContractHdr;
	}
	
}