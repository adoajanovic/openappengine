/**
 * 
 */
package com.openappengine.service;

import com.openappengine.model.salesorder.SalesHdr;

/**
 * @author hrishi
 *
 */
public interface ISalesOrderService {
	
	/**
	 * Create the SalesOrder.
	 * @param salesHdr
	 */
	public void createSalesOrder(SalesHdr salesHdr);

}
