/**
 * 
 */
package com.ms.openapps.cache.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ms.openapps.cache.CacheConfigEntity;
import com.ms.openapps.cache.CacheItem;
import com.ms.openapps.entity.dao.IGenericDao;

/**
 * @author hrishi
 *
 */
public class JpaCacheContextLoader {
	
	private static IGenericDao genericDao;
	
	/**
	 *  Load CacheContext Using Jpa 
	 * @param cacheContexts
	 * @return CacheContext
	 */
	public static CacheContext loadCacheContext(ArrayList<CacheConfigEntity> cacheContexts) throws Exception{
		CacheContext cacheContext = new CacheContext();
		Map<String, List<CacheItem>> entityCache = new HashMap<String, List<CacheItem>>();
		
		if(cacheContexts != null && !cacheContexts.isEmpty()) {
			for(CacheConfigEntity entity : cacheContexts) {
				String hsql = createHQLQuery(entity);
				//TODO - Check the performance for this.
				List cacheList = genericDao.findByQuery(hsql);
				entityCache.put(entity.getId(),populateCacheItem(cacheList, entity));
			}
		}
		cacheContext.setEntityCache(entityCache);
		return cacheContext;
	}
	
	private static List<CacheItem> populateCacheItem(List resultSet,CacheConfigEntity entity) throws Exception{
		List<CacheItem> cacheItems = new ArrayList<CacheItem>();
		Class targetType = entity.getEntity();
		for(Object result : resultSet) {
			CacheItem cacheItem = new CacheItem(result);
			cacheItems.add(cacheItem);
		}
		return cacheItems;
	}
	
	/**
	 *  Create HSQL query from the CacheConfigEntity
	 * @param entity
	 * @return hql query 
	 */
	private static String createHQLQuery(CacheConfigEntity entity ) {
		StringBuffer hqlQuery = new StringBuffer();
		hqlQuery.append(" FROM " );
		hqlQuery.append(entity.getEntity().getName());
		return hqlQuery.toString();
	}
}
