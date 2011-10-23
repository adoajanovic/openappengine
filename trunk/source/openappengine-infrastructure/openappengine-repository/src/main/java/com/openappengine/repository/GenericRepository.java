/**
 * 
 */
package com.openappengine.repository;

import org.springframework.orm.hibernate3.HibernateTemplate;


/**
 * @author hrishi
 *
 */
public class GenericRepository<T> {
	
	protected HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void store(T t) {
		hibernateTemplate.save(t);
	}
	
}
