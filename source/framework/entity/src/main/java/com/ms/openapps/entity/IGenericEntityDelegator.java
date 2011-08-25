/**
 * 
 */
package com.ms.openapps.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author hrishi
 *
 */
public interface IGenericEntityDelegator {

	public GenericEntity createEntity(GenericEntity entity) throws GenericEntityException;
	
	public GenericEntity createEntityClearCache(GenericEntity entity,boolean clearCache) throws GenericEntityException;
	
	public GenericEntity createOrUpdateEntity(GenericEntity entity) throws GenericEntityException;
	
	public GenericEntity createOrUpdateEntity(GenericEntity entity,boolean clearCache) throws GenericEntityException;
	
	public void deleteEntity(GenericEntity entity) throws GenericEntityException;
	
	public void deleteEntity(GenericEntity entity,boolean clearCache) throws GenericEntityException;
	
	public void clearAllCache();

	public GenericEntity find(Serializable pk);
	
	List<GenericEntity> findByQueryString(String queryString, Object[] values);

	List<GenericEntity> findByQueryString(String queryString);

	List findByNamedQuery(String queryName, Map<String, Object> params);
	
	GenericEntity findByNamedParamsSingleResult(String queryName, Map<String, Object> params);

	List findByNamedParams(String queryName, Map<String, Object> params);
}