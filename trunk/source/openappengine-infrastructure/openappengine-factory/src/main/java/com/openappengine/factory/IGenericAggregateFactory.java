/**
 * 
 */
package com.openappengine.factory;

import java.io.Serializable;

import com.openappengine.repository.model.GenericEntity;

/**
 * @author hrishikesh.joshi
 *
 */
public interface IGenericAggregateFactory {
	
	/**
	 * Reconstruct GenericEntity from Repository
	 * @param id
	 * @return {@link GenericEntity}
	 */
	public GenericEntity reconstructEntity(Serializable id);

}
