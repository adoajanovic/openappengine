/**
 * 
 */
package com.openappengine.aggregate.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.factory.resolver.GenericAggregateFactoryResolver;

/**
 * @author hrishikesh.joshi
 *
 */
public class AggregateContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		AggregateContext.applicationContext = applicationContext; 
	}
	
	/**
	 * @return {@link GenericAggregateFactoryResolver}
	 */
	public static GenericAggregateFactoryResolver getFactoryResolver() {
		return (GenericAggregateFactoryResolver) applicationContext.getBean("genericAggregateFactoryResolver");
	}

}
