package com.openappengine.service.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 * 
 */
public class ServiceDefLifecycleHandler {

	private static final String AGGREGATE_CONTEXT_LOCATION = "service-context.xml";

	public void startup() {
		new ClassPathXmlApplicationContext(AGGREGATE_CONTEXT_LOCATION);
	}

	public void shutdown() {
		// TODO
	}

}
