/**
 * 
 */
package com.openappengine.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.openappengine.repository.context.RepositoryContext;
import com.openappengine.repository.jdbc.support.MySQLSequenceIncrementer;



/**
 * @author hrishi
 *
 */
public class GenericRepository {
	
	private static RepositoryContext repositoryContext = RepositoryContext.getInstance();
	
	protected JdbcTemplate jdbcTemplate;
	
	protected HibernateTemplate hibernateTemplate;
	
	protected MySQLSequenceIncrementer incrementer;
	
	protected static SessionFactory sessionFactory;
	
	protected Logger logger = Logger.getLogger(getClass());
	
	static {
		sessionFactory = repositoryContext.getSessionFactory();
	}
	
	public GenericRepository() {
		jdbcTemplate = repositoryContext.getJdbcTemplate();
		incrementer = repositoryContext.getIncrementer();
		hibernateTemplate = repositoryContext.getHibernateTemplate();
	}
	
}
