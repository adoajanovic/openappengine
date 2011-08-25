/**
 * 
 */
package com.ms.openapps.cache.service;

import java.util.List;
import java.util.Map;

import com.ms.openapps.cache.CacheItem;

/**
 * @author hrishi
 *
 */
public class CacheContext {
	
	/* Stores the cached items*/
	private Map<String,List<CacheItem>> entityCache;
	
	/**
	 * @param entityCache2 the entityCache to set
	 */
	public void setEntityCache(Map<String, List<CacheItem>> entityCache) {
		this.entityCache = entityCache;
	}

	/**
	 * @return the entityCache
	 */
	public Map<String,List<CacheItem>> getEntityCache() {
		return entityCache;
	}
	
	

}
