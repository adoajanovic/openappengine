package com.openappengine.repository.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.openappengine.repository.jdbc.support.MySQLSequenceIncrementer;

public class RepositoryContext implements ApplicationContextAware {
	
	private static EntityContextPrvdr entityContextPrvdr;
	
	private static RepositoryContext instance = new RepositoryContext();
	
	protected RepositoryContext() {
	}
	
	public static RepositoryContext getInstance() {
		if(entityContextPrvdr == null) {
			throw new EntityContextConfigurationException("EntityContext has not been initialized");
		}
		return instance;
	}
	
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		entityContextPrvdr = new EntityContextPrvdr(ctx);
		instance = new RepositoryContext();
	}
	
	public EntityContextPrvdr getEntityContext() {
		return entityContextPrvdr;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return (JdbcTemplate) entityContextPrvdr.getBean("jdbcTemplate");
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return (HibernateTemplate) entityContextPrvdr.getBean("hibernateTemplate");
	}
	
	public MySQLSequenceIncrementer getIncrementer() {
		return (MySQLSequenceIncrementer) entityContextPrvdr.getBean("incrementer");
	}
	
	private class EntityContextPrvdr {
		
		private ApplicationContext entityApplicationContext;
		
		private EntityContextPrvdr(ApplicationContext applicationContext) {
			this.entityApplicationContext = applicationContext;
		}
		
		private Object getBean(String beanName) {
			return entityApplicationContext.getBean(beanName);
		}
		
	}
	
}