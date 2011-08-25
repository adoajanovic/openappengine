/**
 * 
 */
package com.ms.openapps.web.context;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 *
 */
public class WebContext implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	private static WebContext webContext = new WebContext();
	
	public static WebContext getInstance() {
		if(applicationContext == null) {
			new ClassPathXmlApplicationContext("webContext.xml");
			//throw new RuntimeException("WebContext Not Initialized");
		}
		return webContext;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		WebContext.applicationContext = applicationContext;
	}
	
	public DozerBeanMapper getDozerMapper() {
		return (DozerBeanMapper) applicationContext.getBean("dozerMapper");
	}

}
