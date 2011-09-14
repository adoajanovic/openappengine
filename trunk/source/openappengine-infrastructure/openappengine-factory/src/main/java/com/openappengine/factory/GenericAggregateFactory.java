/**
 * 
 */
package com.openappengine.factory;

import java.io.Serializable;

import com.openappengine.repository.GenericEntityRepositoryDao;
import com.openappengine.repository.context.EntityContext;
import com.openappengine.repository.model.GenericEntity;

/**
 * @author hrishikesh.joshi
 *
 */
public class GenericAggregateFactory implements IGenericAggregateFactory {
	
	private GenericEntityRepositoryDao entityRepositoryDao;
	
	public GenericAggregateFactory() {
		entityRepositoryDao = EntityContext.getInstance().getGenericEntityRepositoryDAO();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.factory.IGenericAggregateFactory#reconstructEntity(java.io.Serializable)
	 */
	public GenericEntity reconstructEntity(Serializable id) {
		GenericEntity genericEntity = entityRepositoryDao.find(id);
		return genericEntity;
	}

}
