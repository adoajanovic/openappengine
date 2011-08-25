/**
 * 
 */
package com.ms.openapps.entity.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author hrishi
 *
 */
public class EntityLifecycleHandler {
	
	private static final String ENTITY_CONTEXT_DEFINITION = "entityContext.xml";
	
	public EntityLifecycleHandler() {
	}
	
	public void startup() {
		new ClassPathXmlApplicationContext(ENTITY_CONTEXT_DEFINITION);
	}
	
	public void shutdown() {
		//TODO
	}
	
}