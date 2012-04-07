/**
 * 
 */
package com.openappengine.service;

import org.hibernate.Session;

import com.openappengine.entity.EntityEngineFacade;

/**
 * @author hrishi
 *
 */
public class DefaultServiceContext implements ServiceContext {
	
	private Session hibernateSession;
	
	@Override
	public EntityEngineFacade getEngineFacade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getHibernateSession() {
		return hibernateSession;
	}

	public void setHibernateSession(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}

}
