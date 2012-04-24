package com.openappengine.model.product;

import java.io.Serializable;
import javax.persistence.*;

import com.openappengine.model.fm.FmTaxRateProduct;

import java.util.List;


/**
 * The persistent class for the prod_product_type database table.
 * 
 */
@Entity
@Table(name="prod_product_type")
public class ProdProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seqGenerator")  
	@TableGenerator(name="seqGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="PT_PRODUCT_TYPE_ID", unique=true, nullable=false)
	private int ptProductTypeId;

	@Column(name="PT_PRODUCT_TYPE_DESC", nullable=false, length=255)
	private String ptProductTypeDesc;

	//bi-directional many-to-one association to ProdProduct
	@OneToMany(mappedBy="productType")
	private List<FmTaxRateProduct> taxRates;

    public ProdProductType() {
    }

	public int getPtProductTypeId() {
		return this.ptProductTypeId;
	}

	public void setPtProductTypeId(int ptProductTypeId) {
		this.ptProductTypeId = ptProductTypeId;
	}

	public String getPtProductTypeDesc() {
		return this.ptProductTypeDesc;
	}

	public void setPtProductTypeDesc(String ptProductTypeDesc) {
		this.ptProductTypeDesc = ptProductTypeDesc;
	}

	public List<FmTaxRateProduct> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<FmTaxRateProduct> taxRates) {
		this.taxRates = taxRates;
	}
	
}