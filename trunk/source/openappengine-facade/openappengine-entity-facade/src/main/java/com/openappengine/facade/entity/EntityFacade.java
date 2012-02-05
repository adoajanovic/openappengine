/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.openappengine.facade.entity.definition.EntityDefinition;

/**
 * @author hrishikesh.joshi
 *
 */
public interface EntityFacade {
	
	
	/**
	 * @param entityName
	 * @return finds a EntityDefinition instance for the given entity name.
	 */
	EntityDefinition findEntityDefinition(String entityName);
	
	/**
	 * @param entityName
	 * @return A transient EntityValue instance.
	 */
	EntityValue createEntityValue(String entityName);
	
	/**
	 * @param entityName
	 * @param id
	 * @return
	 */
	EntityValue createEntityValue(String entityName,Serializable id);
	
	/**
	 * @param entityName
	 * @param parameters
	 * @return
	 */
	public EntityValue findUniqueEntityValue(String entityName,Map<String,Object> parameters);
	
	/**
	 * Save {@link EntityValue}.
	 * @param entityValue
	 * @return
	 */
	Serializable saveEntityValue(EntityValue entityValue);
	
	EntityValue saveOrUpdateEntityValue(EntityValue entityValue);
	
	List findByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException;
	
	Serializable findOneByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException, EntityValueFindException;

	boolean deleteEntityValue(EntityValue entityValue);
}
