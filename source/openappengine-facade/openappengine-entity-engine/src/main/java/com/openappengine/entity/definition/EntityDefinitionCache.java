/**
 * 
 */
package com.openappengine.entity.definition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.entity.definition.reader.EntityDefinitionReader;

/**
 * @author hrishikesh.joshi
 * 
 */
public class EntityDefinitionCache {

	private Map<String, Entity> entityDefinitionMap = new HashMap<String, Entity>();

	private EntityDefinitionReader entityDefinitionReader;

	public void initEntityDefinitionCache() {
		List<Entity> entityDefinitions = entityDefinitionReader
				.readEntityReaderDefinitions();
		if (entityDefinitions != null) {
			for (Entity definition : entityDefinitions) {
				addEntityDefinitionCache(definition.getEntityName(), definition);
			}
		}
	}

	/**
	 * Get EntityDefinition from Cache by the Entity Name.
	 * 
	 * @param entityName
	 * @return
	 */
	public Entity getEntityDefinition(String entityName) {
		return entityDefinitionMap.get(entityName);
	}

	/**
	 * Add to Cache.
	 * 
	 * @param entityName
	 * @param entityDefinition
	 */
	public void addEntityDefinitionCache(String entityName,
			Entity entityDefinition) {
		if (StringUtils.isEmpty(entityName) || entityDefinition == null) {
			return;
		}

		entityDefinitionMap.put(entityName, entityDefinition);
	}

	public void setEntityDefinitionReader(
			EntityDefinitionReader entityDefinitionReader) {
		this.entityDefinitionReader = entityDefinitionReader;
	}
}
