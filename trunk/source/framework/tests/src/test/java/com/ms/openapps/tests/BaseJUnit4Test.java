/**
 * 
 */
package com.ms.openapps.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ms.openapps.entity.EntityDelegatorFactory;
import com.ms.openapps.entity.context.EntityContext;
import com.ms.openapps.entity.dao.DaoFactory;
import com.ms.openapps.lifecycle.OpenAppsLifecycleHandler;
import com.ms.openapps.oxm.IOxmMapper;
import com.ms.openapps.oxm.OxmMapperContext;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.service.context.ServiceContext;
import com.ms.openapps.service.engine.IGenericServiceEngine;

/**
 * @author hrishi
 *
 */
public class BaseJUnit4Test {
	
	private static OpenAppsLifecycleHandler appsLifecycleHandler;
	
	protected static EntityContext entityContext;
	
	protected EntityDelegatorFactory entityDelegatorFactory;
	
	protected static DaoFactory daoFactory;

	protected IGenericServiceEngine genericServiceEngine;

	protected IOxmMapper oxmMapper;
	
	public BaseJUnit4Test() {
	}

	@BeforeClass
	public static void testStartupLifecycle() {
		appsLifecycleHandler = new OpenAppsLifecycleHandler();
		appsLifecycleHandler.startup();
	}
	
	@AfterClass
	public static void testShutdownLifecycle() {
		appsLifecycleHandler = new OpenAppsLifecycleHandler();
		appsLifecycleHandler.shutdown();
	}

	@Test
	public void testInitServiceEngine() {
		genericServiceEngine = ServiceContext.getGenericServiceEngine();
		Assert.assertNotNull("Generic Service Engine is null.", genericServiceEngine);
	}

	/**
	 * @return 
	 * 
	 */
	protected IOxmMapper getOxmMapper() {
		oxmMapper = OxmMapperContext.getOxmMapper();
		return oxmMapper;
	}

	@Test
	public void testOxmLifecycleHandler() throws OxmMappingException {
		oxmMapper = getOxmMapper();
		Assert.assertNotNull("OXM Mapper Layer failed to initiailize",oxmMapper);
	}
	
}
