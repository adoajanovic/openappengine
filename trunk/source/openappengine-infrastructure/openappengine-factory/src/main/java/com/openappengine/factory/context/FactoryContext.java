/**
 * 
 */
package com.openappengine.factory.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.factory.ModelFactory;

/**
 * @author hrishi
 *
 */
public class FactoryContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		FactoryContext.applicationContext = applicationContext;
	}
	
	public ModelFactory getModelFactory(String factoryName) {
		return applicationContext.getBean(factoryName,ModelFactory.class);
	}

}
