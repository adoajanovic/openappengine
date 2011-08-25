/**
 * 	Entity Delegator Factory
 */
package com.ms.openapps.entity;

import java.util.Map;

import com.ms.openapps.entity.context.exception.EntityContextConfigurationException;

/**
 * @author hrishi
 *
 */
public class EntityDelegatorFactory {
	
	/* Entity Delegator Map */
	private Map<String, ? extends IGenericEntityDelegator> entityDelegatorMap;

	
	public IGenericEntityDelegator getEntityDelegator(String aggregateName) {
		if(!entityDelegatorMap.containsKey(aggregateName)) {
			throw new EntityContextConfigurationException("No Entity found for aggregate " + aggregateName);
		}
		return entityDelegatorMap.get(aggregateName);
	}
	
	/**
	 * @param entityDelegatorMap the entityDelegatorMap to set
	 */
	public void setEntityDelegatorMap(Map<String, ? extends IGenericEntityDelegator> entityDelegatorMap) {
		this.entityDelegatorMap = entityDelegatorMap;
	}

	/**
	 * @return the entityDelegatorMap
	 */
	public Map<String, ? extends IGenericEntityDelegator> getEntityDelegatorMap() {
		return entityDelegatorMap;
	}

}
