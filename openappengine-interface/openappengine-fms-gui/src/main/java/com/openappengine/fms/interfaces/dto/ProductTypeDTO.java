/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @since  Apr 3, 2012
 *
 */
public class ProductTypeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productTypeId;
	
	private String productTypeDesc;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	@Override
	public String toString() {
		return productTypeDesc + " (" + productTypeId + ")";
	}
	
	
}
