/**
 * 
 */
package com.openappengine.service.product;

import java.util.List;

import com.openappengine.model.product.ProdProductType;
import com.openappengine.model.product.Product;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 * @since  Apr 3, 2012
 *
 */
public class ProductServices extends AbstractDomainService {
	
	private ProductRepository productRepository = new ProductRepository();

	private Product product;
	
	private List<ProdProductType> productTypes;
	
	public void fetchProductTypes() {
		productTypes = productRepository.fetchAllProductTypes();
	}
	
	public void addNewProduct() {
		productRepository.saveProduct(product);
	}

	public List<ProdProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProdProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	} 
	
}
