/**
 * 
 */
package com.openappengine.service.invoice;

import com.openappengine.repository.GenericRepository;

/**
 * @author hrishi
 *
 */
public class InvoiceRepository extends GenericRepository {
	
	public int nextInvoiceNumber() {
		int nextValue = incrementer.nextValue("fm_invoice_sequence");
		return nextValue;
	}

}
