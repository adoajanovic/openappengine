/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import com.openappengine.model.product.ProdProductType;
import com.openappengine.model.product.Product;

/**
 * @author hrishikesh.joshi
 * @since  Apr 3, 2012
 *
 */
public class ProductDTOAssembler {
	
	public Product fromDTO(ProductDTO dto) {
		Product product = new Product();
		product.setPdFixedAmount(dto.getFixedAmount());
		product.setPdInternalName(dto.getProductName());
		product.setPdComments(dto.getDescription());
		product.setPdDescription(dto.getDescription());
		product.setPdIntroductionDate(dto.getIntroductionDate());
		product.setPdProductId(dto.getProductId());
		product.setPdProductName(dto.getProductName());
		product.setPdQuantityUom(dto.getQuantityUom());
		
		ProductTypeDTO productTypeDTO = dto.getProductTypeDTO();
		ProdProductType prodProductType = new ProdProductType();
		prodProductType.setPtProductTypeDesc(productTypeDTO.getProductTypeDesc());
		prodProductType.setPtProductTypeId(productTypeDTO.getProductTypeId());
		product.setProdProductType(prodProductType);
		
		return product;
	}

}
