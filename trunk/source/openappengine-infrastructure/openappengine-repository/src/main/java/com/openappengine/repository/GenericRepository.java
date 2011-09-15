/**
 * 
 */
package com.openappengine.repository;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.openappengine.repository.model.GenericEntity;


/**
 * @author hrishi
 *
 */
public class GenericRepository {
	
	private HibernateTemplate hibernateTemplate;
	
	public void save(GenericEntity genericEntity) {
		Serializable save = hibernateTemplate.save(genericEntity);
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
