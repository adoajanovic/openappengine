/**
 * 
 */
package com.ms.openapps.cache.service;

import java.util.List;

import com.ms.openapps.cache.CacheItem;

/**
 * @author hrishi
 *
 */
public interface ICacheService {
	
	/**
	 *  Fetch Cached Item, given the Cache Id.
	 * @param cacheId
	 * @return List<CacheItem>
	 */
	public List<CacheItem> fetchCachedItem(String cacheId);
	
	/**
	 *  Refresh Cached Items
	 */
	public void refreshCache();
	
	/**
	 *  Destroy Cache
	 */
	public void destroyCache();

}
