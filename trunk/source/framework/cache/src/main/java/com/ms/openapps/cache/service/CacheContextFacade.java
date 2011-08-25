/**
 * 
 */
package com.ms.openapps.cache.service;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ms.openapps.cache.CacheConfigEntity;
import com.ms.openapps.cache.exception.CacheCreationException;

/**
 * @author hrishi
 * 
 */
public class CacheContextFacade {

	private static CacheContextFacade instance = new CacheContextFacade();

	private static final String CACHE_ENTITIES = "CacheEntities.xml";

	private static final String NODE_CACHE_ENTITY = "CacheEntity";

	private final Logger logger = Logger.getLogger(getClass());

	private ArrayList<CacheConfigEntity> cacheConfigEntities = new ArrayList<CacheConfigEntity>();

	public CacheContextFacade() {
	}

	/**
	 * Factory Method
	 * 
	 * @return CacheContextFacade instance
	 */
	public static CacheContextFacade getInstance() {
		return instance;
	}

	/**
	 *  Load the CacheContext
	 * @return CacheContext
	 * @throws Exception
	 */
	public CacheContext loadCacheContext() throws Exception {
		CacheContext cacheContext = null;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document configDoc = documentBuilder.parse(new File(CACHE_ENTITIES));
		logger.info("Created the Document for CachedEntities");

		NodeList cacheEntityList = configDoc
				.getElementsByTagName(NODE_CACHE_ENTITY);

		if (cacheEntityList != null && cacheEntityList.getLength() != 0) {
			for (int i = 0; i < cacheEntityList.getLength(); i++) {
				Node cacheConfigNode = cacheEntityList.item(i);
				if (cacheConfigNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cacheConfigElement = (Element) cacheConfigNode;
					cacheConfigEntities
							.add(populateCacheConfigEntity(cacheConfigElement));
				}
			}
			cacheContext = JpaCacheContextLoader
					.loadCacheContext(cacheConfigEntities);
		}
		return cacheContext;
	}

	/**
	 * Populate the CacheConfigEntity from the XML Element.
	 * @param cacheConfigElement
	 * @return CacheConfigEntity
	 * @throws CacheCreationException
	 */
	private CacheConfigEntity populateCacheConfigEntity(
			Element cacheConfigElement) throws CacheCreationException {
		Class<?> entityClass = null;
		CacheConfigEntity cacheConfigEntity = null;
		try {
			String entity = cacheConfigElement.getAttribute("entity");
			entityClass = Class.forName(entity);
			String id = cacheConfigElement.getAttribute("id");
			cacheConfigEntity = new CacheConfigEntity(id, entityClass);
			logger.info("Loading Cache key = " + id + " for Class " + entity);
		} catch (ClassNotFoundException e) {
			logger.error("Entity Not Found ", e);
			throw new CacheCreationException("Entity Not Found");
		}
		return cacheConfigEntity;
	}
}
