/**
 * 
 */
package com.openappengine.service.product;

import java.math.BigDecimal;
import java.util.List;

import com.openappengine.model.fm.FmTaxRateProduct;
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
	
	private BigDecimal calculatedTax;
	
	private BigDecimal priceNet;
	
	private BigDecimal priceGross;
	
	private ProdProductType productType;
	
	public void fetchProductTypes() {
		productTypes = productRepository.fetchAllProductTypes();
	}
	
	public void addNewProduct() {
		productRepository.saveProduct(product);
	}
	
	public void calculateProductAmounts() {
		List<FmTaxRateProduct> taxRates = productRepository.fetchTaxRatesForProductType(getProductType());
		BigDecimal totalTax = new BigDecimal(0.0);
		
		if(taxRates != null) {
			for (FmTaxRateProduct fmTaxRateProduct : taxRates) {
				BigDecimal taxPercentage = fmTaxRateProduct.getTaxPercentage();
				if(taxPercentage != null) {
					totalTax = taxPercentage.multiply(priceNet).divide(new BigDecimal(100));
				}
			}
		}
		calculatedTax = totalTax;
		
		if(calculatedTax != null) {
			priceGross = priceNet.add(calculatedTax);
		}
	}
	
	//Accessors
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

	public BigDecimal getCalculatedTax() {
		return calculatedTax;
	}

	public void setCalculatedTax(BigDecimal calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(BigDecimal priceNet) {
		this.priceNet = priceNet;
	}

	public ProdProductType getProductType() {
		return productType;
	}

	public void setProductType(ProdProductType productType) {
		this.productType = productType;
	}

	public BigDecimal getPriceGross() {
		return priceGross;
	}

	public void setPriceGross(BigDecimal priceGross) {
		this.priceGross = priceGross;
	} 
	
}
