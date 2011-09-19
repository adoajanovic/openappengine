/**
 * 
 */
package com.openappengine.container.startup;

import org.junit.Test;

import com.openappengine.container.OpenAppEngineLifecycleHandler;

/**
 * @author hrishi
 * 
 */
public class TestContainerStartup {

	private OpenAppEngineLifecycleHandler lifecycleEventHandler;

	public TestContainerStartup() {
		lifecycleEventHandler = new OpenAppEngineLifecycleHandler();
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
