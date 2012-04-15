/**
 * 
 */
package com.openappengine.service.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import com.openappengine.model.fm.OhOrderHeader;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderServices extends AbstractDomainService {
	
	private OhOrderHeader orderHeader;
	
	private Integer orderId;
	
	private List<OhOrderHeader> orders;
	
	private String status;
	
	private Date fromDate;
	
	private Date toDate;
	
	private String externalId;
	
	public void createOrder() {
		OrderRepository orderRepository = getRepository(OrderRepository.class);
		orderRepository.createOrder(orderHeader);
		
		orderId = orderHeader.getOrderId();
	}
	
	public void findOrders() {
		Session session = serviceContext.getHibernateSession();
		Criteria criteria = session.createCriteria(OhOrderHeader.class);
		criteria.add(Restrictions.eq("status", status));

		if(StringUtils.isNotEmpty(externalId)) {
			criteria.add(Restrictions.like("externalId", externalId,MatchMode.ANYWHERE));
		}
		
		if(fromDate != null) {
			criteria.add(Restrictions.ge("orderDate", fromDate));
		}
		
		if(toDate != null) {
			criteria.add(Restrictions.le("orderDate", toDate));
		}
		orders = criteria.list();
	}
	
	public void findOrderByExternalId() {
		Session session = serviceContext.getHibernateSession();
		Criteria criteria = session.createCriteria(OhOrderHeader.class);
		criteria.add(Restrictions.eq("externalId", externalId));
		orderHeader = (OhOrderHeader) criteria.uniqueResult();
	}
	
	public void changeOrderStatus() {
		Session session = serviceContext.getHibernateSession();
		
		Criteria criteria = session.createCriteria(OhOrderHeader.class);
		criteria.add(Restrictions.eq("externalId", externalId));
		orderHeader = (OhOrderHeader) criteria.uniqueResult();
		Assert.notNull(orderHeader, "Order Not found.");
		
		orderHeader.setStatus(status);
		session.update(orderHeader);
	}

	//Getters+Setters
	public OhOrderHeader getOrderHeader() {
		return orderHeader;
	}

	public void setOrderHeader(OhOrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<OhOrderHeader> getOrders() {
		return orders;
	}

	public void setOrders(List<OhOrderHeader> orders) {
		this.orders = orders;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

}
