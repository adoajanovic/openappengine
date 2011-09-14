/**
 * 
 */
package com.openappengine.repository;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.openappengine.repository.model.GenericEntity;

/**
 * @author hrishikesh.joshi
 *
 */
public class GenericEntityRepositoryDao extends GenericDAOImpl<GenericEntity, Serializable> {
	
	public GenericEntityRepositoryDao(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
