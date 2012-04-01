package com.openappengine.model.product;


import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the prod_product_type database table.
 * 
 */
@Entity
@Table(name="prod_product_type")
public class ProdProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="addressGenerator")  
	@TableGenerator(name="addressGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="PT_PRODUCT_TYPE_ID")
	private int ptProductTypeId;

	@Column(name="PT_PRODUCT_TYPE_DESC")
	private String ptProductTypeDesc;

	//bi-directional many-to-one association to ProdProduct
	@OneToMany(mappedBy="prodProductType")
	private Set<ProdProduct> prodProducts;

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

	public Set<ProdProduct> getProdProducts() {
		return this.prodProducts;
	}

	public void setProdProducts(Set<ProdProduct> prodProducts) {
		this.prodProducts = prodProducts;
	}
	
}