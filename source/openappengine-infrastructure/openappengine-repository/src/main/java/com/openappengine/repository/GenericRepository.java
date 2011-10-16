/**
 * 
 */
package com.openappengine.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.openappengine.repository.entity.GenericEntity;


/**
 * @author hrishi
 *
 */
public class GenericRepository {
	
	private HibernateTemplate hibernateTemplate;
	
	public GenericEntity save(GenericEntity genericEntity) {
		Serializable save = hibernateTemplate.save(genericEntity);
		return genericEntity;
	}
	
	public List<GenericEntity> findByNamedParam(String queryString, String paramName, Object value) {
		List list = hibernateTemplate.findByNamedParam(queryString, paramName, value);
		return list;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
