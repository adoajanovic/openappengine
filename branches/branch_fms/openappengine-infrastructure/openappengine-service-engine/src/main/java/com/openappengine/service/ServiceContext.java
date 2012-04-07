/**
 * 
 */
package com.openappengine.service;

import org.hibernate.Session;

import com.openappengine.entity.EntityEngineFacade;

/**
 * A context to hold all the service infrastructure, may be passed between
 * services.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public interface ServiceContext {
	
	EntityEngineFacade getEngineFacade();
	
	Session getHibernateSession();

}
