/**
 * 
 */
package com.ms.openapps.tests.lifecycle;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ms.openapps.lifecycle.OpenAppsLifecycleHandler;

/**
 * @author hrishi
 *
 */
public class TestLoadLifecycleConfig {

	private static OpenAppsLifecycleHandler appsLifecycleHandler;
	
	@BeforeClass
	public static void initStartupLifecycle() {
		appsLifecycleHandler = new OpenAppsLifecycleHandler();
		appsLifecycleHandler.startup();
	}
	
	@Test
	public void testStartupLifecycle() {
		Assert.assertNotNull("Lifecycle Not Initialized ", appsLifecycleHandler);
	}
	
	@AfterClass
	public static void shutdownLifecycle() {
		appsLifecycleHandler = new OpenAppsLifecycleHandler();
		appsLifecycleHandler.shutdown();
	}

}