package com.openappengine.repository.context;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.openappengine.repository.GenericRepository;

public class EntityContext implements ApplicationContextAware {
	
	private static EntityContextPrvdr entityContextPrvdr;
	
	private static EntityContext instance = new EntityContext();
	
	protected EntityContext() {
	}
	
	public static EntityContext getInstance() {
		if(entityContextPrvdr == null) {
			throw new EntityContextConfigurationException("EntityContext has not been initialized");
		}
		return instance;
	}
	
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		entityContextPrvdr = new EntityContextPrvdr(ctx);
		instance = new EntityContext();
	}
	
	public EntityContextPrvdr getEntityContext() {
		return entityContextPrvdr;
	}
	
	public SessionFactory getSessionFactory() {
		return (SessionFactory) entityContextPrvdr.getBean("sessionFactory");
	}
	
	public GenericRepository getGenericRepository() {
		return (GenericRepository) entityContextPrvdr.getBean("genericRepository");
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