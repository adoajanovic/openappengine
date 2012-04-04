/**
 * 
 */
package com.openappengine.service.product;

import java.math.BigDecimal;
import java.util.List;

import com.openappengine.model.fm.FmTaxRateProduct;
import com.openappengine.model.product.ProdProductType;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 * @since  Apr 4, 2012
 *
 */
public class ProductTaxServices extends AbstractDomainService {
	
	private ProductRepository productRepository = new ProductRepository();
	
	private BigDecimal calculatedTax;
	
	private BigDecimal priceNet;
	
	private ProdProductType productType;
	
	public void calculateTax() {
		List<FmTaxRateProduct> taxRates = productRepository.fetchTaxRatesForProductType(getProductType());
		BigDecimal tax = new BigDecimal(0.0);
		if(taxRates != null) {
			for (FmTaxRateProduct fmTaxRateProduct : taxRates) {
				tax.add(fmTaxRateProduct.getTaxPercentage());
			}
		}
		calculatedTax = tax.multiply(priceNet).divide(new BigDecimal(100));
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

}
