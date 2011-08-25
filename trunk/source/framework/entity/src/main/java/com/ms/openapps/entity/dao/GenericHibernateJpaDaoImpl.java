/**
 * 
 */
package com.ms.openapps.entity.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.JpaTemplate;

import com.ms.openapps.entity.GenericEntity;

/**
 * @author hrishi
 * @param <T>
 * @param <PK>
 * 
 */
public class GenericHibernateJpaDaoImpl implements IGenericDao {

	private Class<?> type;
	
	private JpaTemplate jpaTemplate;
	
	public GenericHibernateJpaDaoImpl(){		
	}

	public GenericHibernateJpaDaoImpl(Class<?> type) {
		this.type = type;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.catv.persistence.dal.IGenericDao#create(java.lang.Object)
	 */
	@Override
	public GenericEntity save(GenericEntity newInstance) {
		getJpaTemplate().persist(newInstance);
		getJpaTemplate().flush();
		return newInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.catv.persistence.dal.IGenericDao#read(java.io.Serializable)
	 */
	@Override
	public GenericEntity find(Serializable id){
		return (GenericEntity) getJpaTemplate().find(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.catv.persistence.dal.IGenericDao#update(java.lang.Object)
	 */
	@Override
	public GenericEntity saveOrUpdate(GenericEntity transientObject) {
		GenericEntity  t= getJpaTemplate().merge(transientObject);
		getJpaTemplate().flush();
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.catv.persistence.dal.IGenericDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(GenericEntity persistentObject) {
		GenericEntity mergedObject = getJpaTemplate().merge(persistentObject);
		getJpaTemplate().remove(mergedObject);
		getJpaTemplate().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.dal.IGenericDao#findByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	public List<GenericEntity> findByQueryString(String queryName,Object...values){
		return getJpaTemplate().find(queryName, values);
	}
	
	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.dal.IGenericDao#findByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	public List<GenericEntity> findByQueryString(String queryName){
		
		return getJpaTemplate().find(queryName);
	}

	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.dal.IGenericDao#findByNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public List<GenericEntity> findByNamedQuery(String queryName, Map<String, Object> params) {
		return getJpaTemplate().findByNamedParams(queryName, params);
	}

	@Override
	public List<GenericEntity> findByNamedParams(String queryName,
			Map<String, ? extends Object> params) {
		return getJpaTemplate().findByNamedParams(queryName, params);
	}

	@Override
	public List<GenericEntity> findByQuery(String queryString) {
		return getJpaTemplate().find(queryString);
	}

	/**
	 * @param jpaTemplate the jpaTemplate to set
	 */
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	/**
	 * @return the jpaTemplate
	 */
	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Override
	public GenericEntity findByNamedParamsSingleResult(String queryName,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
