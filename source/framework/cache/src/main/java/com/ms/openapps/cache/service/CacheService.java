/**
 * 
 */
package com.ms.openapps.cache.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ms.openapps.cache.CacheItem;

/**
 * @author hrishi
 *
 */
public class CacheService implements ICacheService {

	protected static final CacheContextFacade cacheContextFacade = CacheContextFacade.getInstance();
	
	protected static final CacheService instance = new CacheService();
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	protected CacheContext cacheContext;
	
	private CacheService(){
		refreshCacheContext();
	}
	
	public static CacheService getInstance(){
		return instance;
	}
	
	private void refreshCacheContext() {
		try {
			cacheContext = cacheContextFacade.loadCacheContext();
		} catch (Exception e) {
			logger.error("Exception encountered while loading cache context",e);
		}
	}
	
	@Override
	public void refreshCache() {
		refreshCacheContext();
	}
	
	@Override
	public void destroyCache() {
		cacheContext = null;
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.cache.service.ICacheService#fetchCache(java.lang.String)
	 */
	@Override
	public List<CacheItem> fetchCachedItem(String cacheId) {
		if(cacheContext != null) {
			if(cacheContext.getEntityCache().containsKey(cacheId)) {
				return cacheContext.getEntityCache().get(cacheId);
			}
		}
		return null;
	}
}