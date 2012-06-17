/**
 * 
 */
package com.openappengine.service.impl;


import com.openappengine.model.salesorder.SalesHdr;
import com.openappengine.repository.SalesOrderRepository;
import com.openappengine.service.ISalesOrderService;

/**
 * @author hrishi
 *
 */
public class SalesOrderServiceImpl extends ModelService implements ISalesOrderService {

	private SalesOrderRepository salesOrderRepository;
	
	/* (non-Javadoc)
	 * @see com.openappengine.service.ISalesOrderService#createSalesOrder(com.openappengine.model.salesorder.SalesHdr)
	 */
	public void createSalesOrder(SalesHdr salesHdr) {
		salesOrderRepository.store(salesHdr);
		logger.info("Sales Order Created.");
	}

	public void setSalesOrderRepository(SalesOrderRepository salesOrderRepository) {
		this.salesOrderRepository = salesOrderRepository;
	}

}
