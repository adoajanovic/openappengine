/**
 * 
 */
package com.ms.openapps.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.ms.openapps.entity.dao.IGenericDao;
import com.ms.openapps.util.UtilLogger;

/**
 * @author hrishi
 *
 */
public class GenericEntityDelegator implements IGenericEntityDelegator {

	private IGenericDao genericDao;
	
	private UtilLogger logger  = new UtilLogger(getClass());
	
	public GenericEntityDelegator(IGenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	/**
	 */
	public GenericEntityDelegator() {
		//Do not use this programmatically. Public Constructor included for using Aspects.
	}
	
	public GenericEntity find(Serializable pK) {
		return (GenericEntity) genericDao.find(pK);
	}
	
	@Override
	public GenericEntity createEntity(GenericEntity entity) throws GenericEntityException {
		logger.logInfo("Persisting the entity : " + entity);
		return (GenericEntity) genericDao.save(entity);
	}

	@Override
	public GenericEntity createEntityClearCache(GenericEntity entity, boolean clearCache)
			throws GenericEntityException {
		// TODO
		throw new NotImplementedException();
	}

	@Override
	public GenericEntity createOrUpdateEntity(GenericEntity entity) throws GenericEntityException {
		logger.logInfo("Storing the entity : " + entity);
		return (GenericEntity) genericDao.saveOrUpdate(entity);
	}

	@Override
	public GenericEntity createOrUpdateEntity(GenericEntity entity, boolean clearCache)
			throws GenericEntityException {
		// TODO
		throw new NotImplementedException();
	}

	@Override
	public void deleteEntity(GenericEntity entity) throws GenericEntityException {
		logger.logInfo("Deleting the entity : " + entity);
		genericDao.delete(entity);
	}

	@Override
	public void deleteEntity(GenericEntity entity, boolean clearCache)
			throws GenericEntityException {
		//TODO
		throw new NotImplementedException();
	}

	@Override
	public void clearAllCache() {
		//TODO
		throw new NotImplementedException();
	}

	@Override
	public List<GenericEntity> findByQueryString(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenericEntity> findByQueryString(String queryString) {
		return genericDao.findByQueryString(queryString);
	}

	@Override
	public List findByNamedQuery(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericEntity findByNamedParamsSingleResult(String queryName,
			Map<String, Object> params) {
		return genericDao.findByNamedParamsSingleResult(queryName, params);
	}

}