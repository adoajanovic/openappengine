/**
 * 
 */
package com.openappengine.service.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.service.impl.ModelService;

/**
 * @author hrishikesh.joshi
 */
public class ServiceContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ServiceContext.applicationContext = applicationContext; 
	}

	/**
	 * @param serviceName
	 * @return Service
	 */
	public static ModelService getService(String serviceName) {
		return (ModelService) applicationContext.getBean(serviceName);
	}
	
}
