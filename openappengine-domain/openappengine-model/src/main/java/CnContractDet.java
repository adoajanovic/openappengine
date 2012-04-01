

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cn_contract_det database table.
 * 
 */
@Entity
@Table(name="cn_contract_det")
public class CnContractDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CN_CONTRACT_DET_ID")
	private int cnContractDetId;

	@Column(name="CN_COST")
	private BigDecimal cnCost;

	@Column(name="CN_DISCOUNT")
	private BigDecimal cnDiscount;

	@Column(name="CN_ITEM_ID")
	private int cnItemId;

	@Column(name="CN_LOCATION")
	private String cnLocation;

	@Column(name="CN_LOT_NO")
	private String cnLotNo;

	@Column(name="CN_ORD_TYPE")
	private String cnOrdType;

	@Column(name="CN_PRICE")
	private BigDecimal cnPrice;

	@Column(name="CN_QTY_ORD")
	private BigDecimal cnQtyOrd;

	@Column(name="CN_UOM")
	private String cnUom;

	@Column(name="CN_WEIGHT")
	private BigDecimal cnWeight;

	//bi-directional many-to-one association to CnContractHdr
    @ManyToOne
	@JoinColumn(name="CN_CONTRACT_ID")
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