/**
 * 
 */
package com.openappengine.fms.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.ProductTypeDTO;
import com.openappengine.model.product.ProdProductType;


/**
 * @author hrishi
 *
 */
public interface FleetManagerServiceFacade {
	
	/**
	 * Load Customer information for viewing details/editing.
	 * @param partyId
	 * @return
	 */
	CustomerDTO loadCustomerDTO(Integer partyId);

	/**
	 * Save Customer (Person Party).
	 * @param dto
	 */
	void saveCustomer(CustomerDTO dto);
	
	/**
	 * Load all "ACTIVE" customers.
	 * @return
	 */
	List<CustomerDTO> loadActiveCustomerDTOs();

	/**
	 * Update Existing Customer.
	 * @param dto
	 */
	void updateCustomer(CustomerDTO dto);

	/**
	 * @return
	 */
	List<ProductTypeDTO> loadAllProductTypes();

	/**
	 * @param dto
	 */
	void addNewProduct(ProductDTO dto);

	/**
	 * @param type
	 * @param netPrice
	 * @return
	 */
	BigDecimal calculateTaxAmount(ProductTypeDTO dto, BigDecimal netPrice);
	
}
