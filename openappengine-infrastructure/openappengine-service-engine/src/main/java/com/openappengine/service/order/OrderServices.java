/**
 * 
 */
package com.openappengine.service.order;

import com.openappengine.model.fm.OhOrderHeader;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderServices extends AbstractDomainService {
	
	private OhOrderHeader orderHeader;
	
	

	public OhOrderHeader getOrderHeader() {
		return orderHeader;
	}

	public void setOrderHeader(OhOrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}

}
