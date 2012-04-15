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
		int nextOrderNumber = orderRepository.nextOrderNumber();
		String number = String.format("%05d", nextOrderNumber);
		orderNumber = "OR" + number;
	}
	
	//Getters+Setters
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
