/**
 * 
 */
package com.openappengine.service.order;

import com.openappengine.repository.GenericRepository;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderRepository extends GenericRepository {
	
	public int nextOrderNumber() {
		int nextValue = incrementer.nextValue("fm_order_sequence");
		return nextValue;
	}

}
