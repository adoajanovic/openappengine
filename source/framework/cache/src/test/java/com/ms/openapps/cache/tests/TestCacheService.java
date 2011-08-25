package com.ms.openapps.cache.tests;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.ms.openapps.cache.CacheConstants;
import com.ms.openapps.cache.CacheItem;
import com.ms.openapps.cache.service.CacheService;
import com.ms.openapps.cache.service.ICacheService;

/**
 * @author hrishi
 *
 */
@ContextConfiguration(value="/test-cache-service-context.xml")
public class TestCacheService extends AbstractJUnit38SpringContextTests{
	
	private ICacheService cacheService;
	private String cacheId = CacheConstants.UOM_TYPES;
	
	@Before
	public void setup() {
		cacheService = CacheService.getInstance();
		assertNotNull("Cache Service Null", cacheService);
	}
	
	@Test
	public void testfetchCache(){
		cacheService = CacheService.getInstance();
		List<CacheItem> fetchCache = cacheService.fetchCachedItem(cacheId);
		assertNotNull("Not Cache Items found", fetchCache);
	}
	
	@Test
	public void testRefreshCache(){
		//TODO - Have to determine an algorithm to test the refresh method
		assertTrue(true);
	}
	
	@Test
	public void testDestoryCache(){
		cacheService = CacheService.getInstance();
		cacheService.destroyCache();
		List<CacheItem> fetchCache = cacheService.fetchCachedItem(cacheId);
		assertNull("Fetched CachedItem not null",fetchCache);
	}
}