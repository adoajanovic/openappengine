/**
 * 
 */
package com.openappengine.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 *
 */
public class ServiceEngineContextStartup {
	
	public void startup() {
		new ClassPathXmlApplicationContext("service-engine-context.xml");
	}

}
