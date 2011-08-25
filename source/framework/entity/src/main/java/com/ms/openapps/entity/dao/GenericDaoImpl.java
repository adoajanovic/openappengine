/**
 * 
 */
package com.ms.openapps.entity.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ms.openapps.entity.GenericEntity;

/**
 * @author hrishi
 *
 */
public class GenericDaoImpl implements IGenericDao {
	
	private EntityManager em;

	private Class<?> clazz;
	
	public GenericDaoImpl(){
	}
	
	public GenericDaoImpl(EntityManager em,Class clazz) {
		this.em = em;
		this.clazz = clazz;
	}
	
	private void setNamedQueryParameters(Query query,Map<String,Object> params) {
		if(params != null) {
			Set<String> keySet = params.keySet();
			if(keySet != null) {
				for (String key : keySet) {
					query.setParameter(key, params.get(key));
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#save(com.ms.openapps.entity.GenericEntity)
	 */
	@Override
	public GenericEntity save(GenericEntity newInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#find(java.io.Serializable)
	 */
	@Override
	public GenericEntity find(Serializable id) {
		return (GenericEntity) em.find(clazz, id);
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByQueryString(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<GenericEntity> findByQueryString(String queryName,
			Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByQueryString(java.lang.String)
	 */
	@Override
	public List<GenericEntity> findByQueryString(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public List<GenericEntity> findByNamedQuery(String queryName,
			Map<String, Object> params) {
		Query query = em.createNamedQuery(queryName);
		setNamedQueryParameters(query,params);
		return query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public GenericEntity findByNamedParamsSingleResult(String queryName,
			Map<String, Object> params) {
		Query query = em.createQuery(queryName);
		setNamedQueryParameters(query,params);
		return (GenericEntity) query.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByNamedParams(java.lang.String, java.util.Map)
	 */
	@Override
	public List<GenericEntity> findByNamedParams(String queryName,
			Map<String, ? extends Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#saveOrUpdate(com.ms.openapps.entity.GenericEntity)
	 */
	@Override
	public GenericEntity saveOrUpdate(GenericEntity transientObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#delete(com.ms.openapps.entity.GenericEntity)
	 */
	@Override
	public void delete(GenericEntity persistentObject) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.entity.dao.IGenericDao#findByQuery(java.lang.String)
	 */
	@Override
	public List<GenericEntity> findByQuery(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

}
