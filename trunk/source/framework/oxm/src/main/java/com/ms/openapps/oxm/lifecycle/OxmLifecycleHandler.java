/**
 * 
 */
package com.ms.openapps.oxm.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 * 
 */
public class OxmLifecycleHandler {

	private static final String OXM_CONTEXT_LOCATION = "oxmContext.xml";

	private ClassPathXmlApplicationContext applicationContext;

	public void startup() {
		applicationContext = new ClassPathXmlApplicationContext(
				OXM_CONTEXT_LOCATION);
	}

	public void shutdown() {
		applicationContext = null;
	}

}
