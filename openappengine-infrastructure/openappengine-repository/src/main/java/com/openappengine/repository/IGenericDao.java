/**
 * 
 */
package com.openappengine.repository;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public interface IGenericDao<T> {
	
	void save(T t);

	T findUnique(Serializable id);
	
}
