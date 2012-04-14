/**
 * 
 */
package com.openappengine.service.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.util.Assert;

import com.openappengine.model.fm.FmTaxRateProduct;
import com.openappengine.model.product.PriceTypeConstants;
import com.openappengine.model.product.ProdProductPrice;
import com.openappengine.model.product.ProdProductPriceType;
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
	
	private BigDecimal listPrice;
	
	private BigDecimal priceTax;
	
	private Date fromDate;
	
	private Date toDate;
	
	private BigDecimal priceGross;
	
	private String taxType;
	
	private ProdProductType productType;
	
	private List<Product> products;
	
	public void fetchProductTypes() {
		productTypes = productRepository.fetchAllProductTypes();
	}
	
	public void addNewProduct() {
		productRepository.saveProduct(product);
	}
	
	public void addListPrice() {
		ProdProductPrice prodProductPrice = new ProdProductPrice();
		prodProductPrice.setPpPrice(getListPrice());
		prodProductPrice.setPpFromDate(fromDate);
		prodProductPrice.setPpToDate(toDate);
		prodProductPrice.setPpCurrencyUomId("INR");
		prodProductPrice.setProdProduct(product);
		
		ProdProductPriceType productPriceType = productRepository.getProductPriceType(serviceContext.getHibernateSession(),PriceTypeConstants.PRICE_TYPE_LIST_PRICE);
		Assert.notNull(productPriceType, "Product Price Type " + PriceTypeConstants.PRICE_TYPE_LIST_PRICE + " not found.!");
		prodProductPrice.setProdProductPriceType(productPriceType);
		serviceContext.getHibernateSession().saveOrUpdate(prodProductPrice);
	}
	
	public void calculateTax() {
		List<FmTaxRateProduct> taxRates = productRepository.fetchTaxRatesForProductType(getProductType());
		BigDecimal totalTax = new BigDecimal(0.0);
		
		if(taxRates != null) {
			for (FmTaxRateProduct fmTaxRateProduct : taxRates) {
				BigDecimal taxPercentage = fmTaxRateProduct.getTaxPercentage();
				if(taxPercentage != null) {
					totalTax = taxPercentage.multiply(getListPrice()).divide(new BigDecimal(100));
				}
			}
		}
		calculatedTax = totalTax;
		
		if(calculatedTax != null) {
			priceGross = getListPrice().add(calculatedTax);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadAllActiveProducts() {
		Session session = serviceContext.getHibernateSession();
		Criteria criteria = session.createCriteria(Product.class);
		products = criteria.list();
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public BigDecimal getPriceTax() {
		return priceTax;
	}

	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}
	
}
