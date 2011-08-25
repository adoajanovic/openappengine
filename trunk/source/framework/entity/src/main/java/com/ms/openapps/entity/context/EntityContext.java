package com.ms.openapps.entity.context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.PlatformTransactionManager;

import com.ms.openapps.entity.EntityDelegatorFactory;
import com.ms.openapps.entity.context.exception.EntityContextConfigurationException;
import com.ms.openapps.entity.dao.DaoFactory;

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
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		entityContextPrvdr = new EntityContextPrvdr(ctx);
		instance = new EntityContext();
	}
	
	public EntityContextPrvdr getEntityContext() {
		return entityContextPrvdr;
	}
	
	public DaoFactory getDaoFactory() {
		return (DaoFactory) entityContextPrvdr.getBean(EntityContextConstants.BEAN_DAO_FACTORY);
	}
	
	public EntityDelegatorFactory getEntityDelegatorFactory() {
		return (EntityDelegatorFactory) entityContextPrvdr.getBean(EntityContextConstants.BEAN_ENTITY_DELEGATOR_FACTORY);
	}
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) entityContextPrvdr.getBean(EntityContextConstants.BEAN_ENTITY_MANAGER_FACTORY);
		return entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Get the Transaction Manager
	 * Currently used directly by the service-engine
	 * @return PlatformTransactionManager
	 */
	public PlatformTransactionManager getPlatformTransactionManager() {
		return (PlatformTransactionManager) entityContextPrvdr.getBean(EntityContextConstants.BEAN_TRANSACTION_MANAGER);
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