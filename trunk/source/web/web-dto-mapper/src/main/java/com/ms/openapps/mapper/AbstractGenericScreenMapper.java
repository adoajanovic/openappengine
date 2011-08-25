/**
 * 
 */
package com.ms.openapps.mapper;

import javax.persistence.EntityManager;

import org.springframework.transaction.PlatformTransactionManager;

import com.ms.openapps.entity.EntityDelegatorFactory;
import com.ms.openapps.entity.GenericEntityDelegator;
import com.ms.openapps.entity.context.EntityContext;


/**
 * @author hrishi
 *
 */
public abstract class AbstractGenericScreenMapper implements IScreenMapper {

	private EntityContext getEntityContext() {
		EntityContext entityContext = null;
		if(entityContext == null) {
			entityContext = EntityContext.getInstance();
		}
		return entityContext;
	}
	
	protected EntityManager getEntityManager() {
		EntityContext entityContext = getEntityContext();
		EntityManager em = entityContext.getEntityManager();
		return em;
	}
	
	protected EntityDelegatorFactory getEntityDelegatorFactory() {
		return getEntityContext().getEntityDelegatorFactory();
	}
	
	protected PlatformTransactionManager getPlatformTransactionManager() {
		return getEntityContext().getPlatformTransactionManager();
	}
	
	protected <T extends GenericEntityDelegator> T getGenericEntityDelegator(String delegator) {
		return (T) getEntityDelegatorFactory().getEntityDelegator(delegator);
	}

}
