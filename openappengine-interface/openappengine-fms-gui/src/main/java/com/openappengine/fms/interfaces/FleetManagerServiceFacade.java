/**
 * 
 */
package com.openappengine.fms.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.CustomerSearchResultDTO;
import com.openappengine.fms.interfaces.dto.OrderListItemDTO;
import com.openappengine.fms.interfaces.dto.OrderSearchDTO;
import com.openappengine.fms.interfaces.dto.ProductAmountDTO;
import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.ProductItemListDTO;
import com.openappengine.fms.interfaces.dto.ProductTypeDTO;
import com.openappengine.fms.interfaces.dto.SalesOrderDTO;
import com.openappengine.service.api.ServiceException;


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
	ProductAmountDTO calculateTaxAmount(ProductTypeDTO dto, BigDecimal netPrice);

	org.apache.pivot.collections.List<CustomerSearchResultDTO> findPartyByName(String firstName,String middleName, String lastName);

	org.apache.pivot.collections.List<ProductItemListDTO> getAllActiveProducts();

	void createOrder(SalesOrderDTO salesOrderDTO);

	String getSalesOrderExternalId() throws ServiceException;

	org.apache.pivot.collections.List<OrderListItemDTO> loadOrderListItems(OrderSearchDTO dto);

	SalesOrderDTO getSalesOrderDTO(String externalId);

	void cancelSalesOrder(String externalId);

	void printOrder(String externalId);
	
}
