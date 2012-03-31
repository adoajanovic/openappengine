/**
 * 
 */
package com.openappengine.fms.interfaces;

import java.util.List;

import com.openappengine.fms.interfaces.dto.CustomerDTO;


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
	
}
