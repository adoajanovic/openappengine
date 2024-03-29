/**
 * 
 */
package com.openappengine.entity.delegator;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.entity.api.ValueEntity;
import com.openappengine.entity.model.ModelEntity;

/**
 * The Delagator interface abstracts all the core low-level activities
 * like DB operations, Cache etc.
 * 
 * @author hrishi
 * since Mar 5, 2012
 */
public interface Delegator {
	
	/**
	 * Create a new <code>ValueEntity</code> instance without persisting it.
	 * @param entityName
	 * @return
	 */
	ValueEntity makeValueEntity(String entityName);
	
	/**
	 * Create a new <code>ValueEntity</code> instance, and fill it with the values given, without persisting it.
	 * @param entityName
	 * @param values
	 * @return
	 */
	ValueEntity makeValueEntity(String entityName,Map<String, Object> values);
	
	/**
	 * Create a new instance of <code>ValueEntity</code> and persist it.
	 * If there is already an existing instance with the same PK, for this entity,
	 * throws an exception.
	 *
	 * @param entityName
	 * @param values
	 * @return
	 */
	ValueEntity createEntity(String entityName,Map<String, Object> values);
	
	/**
	 * Create a new instance of <code>ValueEntity</code> and persist it - Try to save
	 * the instance, if there is already an existing instance, update the same.
	 * @param entityName
	 * @param values
	 * @return
	 */
	ValueEntity storeEntity(String entityName,Map<String, Object> values);
	
	/**
	 * Find a <code>ValueEntity</code> from the datastore, by primary key. 
	 * @param entityName
	 * @param values
	 * @return
	 */
	ValueEntity findByPrimaryKey(String entityName,Map<String, Object> values);
	
	/**
	 * Get a ModelEntity by entityname.
	 * @param entityName
	 * @return
	 */
	ModelEntity getModelEntity(String entityName);
	
	/**
	 * Get {@link ValueEntity} as XML.
	 * @param entityName
	 * @return
	 */
	Document makeValueEntityAsXml(String entityName);
	
	/**
	 * Get {@link ValueEntity} as XML.
	 * @param entityName
	 * @param values
	 * @return
	 */
	Document makeValueEntityAsXml(String entityName,Map<String, Object> values);
	
	/**
	 * Create {@link ValueEntity} from XML Document.
	 * @param document
	 * @return
	 */
	ValueEntity fromXml(Document document);
	
	/**
	 * Add an entry of the related entity in the original value entity, if does not exists, 
	 * for the original entity.
	 *   
	 * @param valueEntity
	 * @param relationshipName
	 * @return
	 */
	ValueEntity makeRelatedValueEntity(ValueEntity valueEntity, String relationshipName);
}
