/**
 * 
 */
package com.ms.openapps.entity.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ms.openapps.entity.GenericEntity;

/**
 * @author hrishi
 * A Generic Dao Implementation
 */
public interface IGenericDao {
    
    /** Persist the newInstance object into database */
    public GenericEntity save(GenericEntity newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    public GenericEntity find(Serializable id);
    
    /**
     *  Retrieve an object that was previously persisted to the database using NamedQuery
     * @param queryName
     * @param values
     * @return
     */
    public List<GenericEntity> findByQueryString(String queryName,Object...values);
    
    /**
     *  Retrieve an object using the query string
     * @param queryName
     * @param values
     * @return
     */
    public List<GenericEntity> findByQueryString(String queryName);
    
    /**
     *  Retrieve an object that was previously persisted to the database using NamedQuery
     * @param queryName
     * @param values
     * @return
     */
    public List<GenericEntity> findByNamedQuery(String queryName,Map<String,Object> params);
    
    /**
     *  Retrieve an object that was previously persisted to the database using NamedQuery
     * @param queryName
     * @param values
     * @return
     */
    public List<GenericEntity> findByNamedParams(String queryName,Map<String,? extends Object> params);

    /** Save changes made to a persistent object.  
     * @return */
    public GenericEntity saveOrUpdate(GenericEntity transientObject);

    /** Remove an object from persistent storage in the database */
    public void delete(GenericEntity persistentObject);
    
    
    public List<GenericEntity> findByQuery(String queryString);

	GenericEntity findByNamedParamsSingleResult(String queryName,
			Map<String, Object> params);

}
