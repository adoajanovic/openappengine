/**
 * 
 */
package com.openappengine.service.order;

import org.hibernate.Session;

import com.openappengine.model.fm.OhOrderHeader;
import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.HibernateUtils;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderRepository extends GenericRepository {
	
	public int nextOrderNumber() {
		int nextValue = incrementer.nextValue("fm_order_sequence");
		return nextValue;
	}

	public void createOrder(OhOrderHeader orderHeader) {
		Session session = HibernateUtils.getExistingSession();
		session.save(orderHeader);
	}
}
