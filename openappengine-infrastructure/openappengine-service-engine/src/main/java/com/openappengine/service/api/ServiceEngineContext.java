/**
 * 
 */
package com.openappengine.service.api;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public class ServiceEngineContext implements ApplicationContextAware {
	
	private static final String BEAN_DEFAULT_SERVICE_DISPATCHER = "defaultServiceDispatcher";
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	public static ServiceDispatcher getDefaultServiceDispatcher() {
		return context.getBean(BEAN_DEFAULT_SERVICE_DISPATCHER,ServiceDispatcher.class);
	}

}
