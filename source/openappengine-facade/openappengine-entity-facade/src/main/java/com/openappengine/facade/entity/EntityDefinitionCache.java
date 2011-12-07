/**
 * 
 */
package com.openappengine.facade.entity;

import java.util.HashMap;
import java.util.Map;

import com.openappengine.facade.entity.api.EntityDefinition;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinitionCache {
	
	private Map<String,EntityDefinition> entityDefinitionMap = new HashMap<String, EntityDefinition>();

	public Map<String,EntityDefinition> getEntityDefinitionMap() {
		return entityDefinitionMap;
	}

	public void setEntityDefinitionMap(Map<String,EntityDefinition> entityDefinitionMap) {
		this.entityDefinitionMap = entityDefinitionMap;
	}
	
	public EntityDefinition getEntityDefinition(String entityName) {
		return entityDefinitionMap.get(entityName);
	}

}
