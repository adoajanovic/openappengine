/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.w3c.dom.Document;

import com.openappengine.entity.api.ValueEntity;
import com.openappengine.entity.definition.Entity;
import com.openappengine.entity.response.EntityResponse;

/**
 * @author hrishikesh.joshi
 *
 */
public interface EntityEngineFacade {
	
	
	/**
	 * @param entityName
	 * @return finds a EntityDefinition instance for the given entity name.
	 */
	Entity findEntityDefinition(String entityName);
	
	/**
	 * @param entityName
	 * @param isXml TODO
	 * @return A transient PojoEntityValue instance.
	 */
	EntityValue createEntityValue(String entityName, boolean isXml);
	
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
	 * @param pojoEntityValue
	 * @return
	 */
	EntityValue saveEntityValue(EntityValue pojoEntityValue);
	
	EntityValue saveOrUpdateEntityValue(EntityValue pojoEntityValue);
	
	List findByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException;
	
	Serializable findOneByPropertyValues(Class entityClass, Map<String, Object> parameters) throws DataAccessException, EntityValueFindException;

	boolean deleteEntityValue(EntityValue pojoEntityValue);
	
	EntityValue createXmlEntityValue(String entityName);
	
	EntityResponse createEntityValue(String entityName);
	
	//
	Document makeValueEntityAsXml(String entityName,Map<String, Object> values);
	
	Document makeValueEntityAsXml(String entityName);
	
	ValueEntity makeValueEntity(String entityName);
	
	ValueEntity makeValueEntity(String entityName,Map<String, Object> values);
}
