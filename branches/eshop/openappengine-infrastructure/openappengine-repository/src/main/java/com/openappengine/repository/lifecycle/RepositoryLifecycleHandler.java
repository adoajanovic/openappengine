/**
 * 
 */
package com.openappengine.repository.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 * 
 */
public class RepositoryLifecycleHandler {

	private static final String SERVICE_ENGINE_CONTEXT_LOCATION = "repository-context.xml";

	public void startup() {
		new ClassPathXmlApplicationContext(SERVICE_ENGINE_CONTEXT_LOCATION);
	}

	public void shutdown() {
		// TODO
	}

}
