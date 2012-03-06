/**
 * 
 */
package com.openappengine.entity.delegator;

import java.util.Map;

import com.openappengine.entity.api.ValueEntity;

/**
 * The Delagator interface abstracts all the core low-level activities
 * like DB operations, Cache etc.
 * 
 * @author hrishi
 * since Mar 5, 2012
 */
public interface Delegator {
	
	ValueEntity makeValueEntity(String entityName);
	
	ValueEntity makeValueEntity(String entityName,Map<String, Object> values);
	
	ValueEntity createEntity(String entityName,Map<String, Object> values);
	
	ValueEntity storeEntity(String entityName,Map<String, Object> values);
	
	ValueEntity findByPrimaryKey(String entityName,Map<String, Object> values);
}
