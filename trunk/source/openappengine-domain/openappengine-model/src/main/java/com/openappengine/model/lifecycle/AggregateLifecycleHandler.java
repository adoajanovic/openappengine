package com.openappengine.model.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 * 
 */
public class AggregateLifecycleHandler {

	private static final String AGGREGATE_CONTEXT_LOCATION = "aggregate-context.xml";

	public void startup() {
		new ClassPathXmlApplicationContext(AGGREGATE_CONTEXT_LOCATION);
	}

	public void shutdown() {
		// TODO
	}

}
