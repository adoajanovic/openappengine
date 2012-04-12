/**
 * 
 */
package com.openappengine.service.order;

import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderCommonServices extends AbstractDomainService {
	
	private String orderNumber;
	
	private OrderRepository orderRepository = new OrderRepository();

	public void getNextOrderNumber() {
		orderNumber = "" + orderRepository.nextOrderNumber();
	}
	
	//Getters+Setters
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
