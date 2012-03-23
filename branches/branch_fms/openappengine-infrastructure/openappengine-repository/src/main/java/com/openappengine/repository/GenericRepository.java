/**
 * 
 */
package com.openappengine.repository;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openappengine.repository.context.RepositoryContext;
import com.openappengine.repository.jdbc.support.MySQLSequenceIncrementer;



/**
 * @author hrishi
 *
 */
public class GenericRepository {
	
	private static RepositoryContext repositoryContext = RepositoryContext.getInstance();
	
	protected JdbcTemplate jdbcTemplate;
	
	protected MySQLSequenceIncrementer incrementer;
	
	protected Logger logger = Logger.getLogger(getClass());
	
	public GenericRepository() {
		jdbcTemplate = repositoryContext.getJdbcTemplate();
		incrementer = repositoryContext.getIncrementer();
	}
	
}