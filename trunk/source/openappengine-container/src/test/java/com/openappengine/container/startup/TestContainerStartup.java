/**
 * 
 */
package com.openappengine.container.startup;

import org.junit.Test;

import com.openappengine.container.OpenAppsLifecycleHandler;

/**
 * @author hrishi
 * 
 */
public class TestContainerStartup {

	private OpenAppsLifecycleHandler lifecycleEventHandler;

	public TestContainerStartup() {
		lifecycleEventHandler = new OpenAppsLifecycleHandler();
	}

	@Test
	public void testStartup() {
		lifecycleEventHandler.startup();
	}

	@Test
	public void testShutdown() {
		lifecycleEventHandler.shutdown();
	}
}
