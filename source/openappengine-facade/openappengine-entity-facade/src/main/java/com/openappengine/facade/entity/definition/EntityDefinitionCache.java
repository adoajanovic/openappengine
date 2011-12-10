/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinitionCache {
	
	private Map<String,EntityDefinition> entityDefinitionMap = new HashMap<String, EntityDefinition>();
	
	private EntityDefinitionReader entityDefinitionReader;

	public void initEntityDefinitionCache() {
	    List<EntityDefinition> entityDefinitions = entityDefinitionReader.readEntityReaderDefinitions();
	    if(entityDefinitions != null) {
		for (EntityDefinition definition : entityDefinitions) {
		    addEntityDefinitionCache(definition.getEntityName(), definition);
		}
	    }
	}
	
	/**
	 * Get EntityDefinition from Cache by the Entity Name.
	 * @param entityName
	 * @return
	 */
	public EntityDefinition getEntityDefinition(String entityName) {
		return entityDefinitionMap.get(entityName);
	}
	
	/**
	 * Add to Cache.
	 * @param entityName
	 * @param entityDefinition
	 */
	public void addEntityDefinitionCache(String entityName, EntityDefinition entityDefinition) {
	    if(StringUtils.isEmpty(entityName) || entityDefinition == null) {
		return;
	    }
	    
	    entityDefinitionMap.put(entityName, entityDefinition);
	}

	public void setEntityDefinitionReader(EntityDefinitionReader entityDefinitionReader) {
	    this.entityDefinitionReader = entityDefinitionReader;
	}
}
