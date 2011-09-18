/**
 * 
 */
package com.openappengine.serviceengine.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 *
 */
public class ServiceEngineLifecycleHandler {
	
	private static final String SERVICE_ENGINE_CONTEXT_LOCATION = "serviceEngineContext.xml";
	
	public void startup() {
		new ClassPathXmlApplicationContext(SERVICE_ENGINE_CONTEXT_LOCATION);
	}
	
	public void shutdown() {
		//TODO
	}

}
