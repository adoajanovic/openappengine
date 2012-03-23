/**
 * 
 */
package com.openappengine.entity.datasource;

import java.io.Serializable;

import com.openappengine.entity.api.ValueEntity;

/**
 * @author hrishi
 * since Mar 17, 2012
 */
public interface EntityHelper {
	
	/**
	 * Save the ValueEntity, if the <code>ValueEntity</code> exists, throw an Exception.
	 * @param valueEntity
	 * @return
	 * @throws EntityException
	 */
	int create(ValueEntity valueEntity) throws EntityException;
	
	/**
	 * Find the <code>ValueEntity</code> by PK.
	 * @param pk
	 * @return
	 */
	ValueEntity findValueEntityByPK(Serializable pk);

}
