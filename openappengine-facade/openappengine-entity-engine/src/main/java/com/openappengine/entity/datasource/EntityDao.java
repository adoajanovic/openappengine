/**
 * 
 */
package com.openappengine.entity.datasource;

import com.openappengine.entity.api.ValueEntity;

/**
 * @author hrishi
 * since Mar 17, 2012
 */
public interface EntityDao {
	
	/**
	 * @param valueEntity
	 * @return
	 */
	int save(ValueEntity valueEntity);

}
