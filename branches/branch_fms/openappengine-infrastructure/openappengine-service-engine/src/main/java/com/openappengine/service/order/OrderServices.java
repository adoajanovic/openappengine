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
	
	public void createOrder() {
		OrderRepository orderRepository = getRepository(OrderRepository.class);
		orderRepository.createOrder(orderHeader);
	}

	//Getters+Setters
	public OhOrderHeader getOrderHeader() {
		return orderHeader;
	}

	public void setOrderHeader(OhOrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}

}
