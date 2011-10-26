/**
 * 
 */
package com.openappengine.facade.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 *
 */
public class FacadeLifecycleHandler {
	
	private static final String SERVICE_ENGINE_CONTEXT_LOCATION = "facade-context.xml";

	public void startup() {
		new ClassPathXmlApplicationContext(SERVICE_ENGINE_CONTEXT_LOCATION);
	}

	public void shutdown() {
		// TODO
	}


}
