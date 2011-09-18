/**
 * 
 */
package com.openappengine.serviceengine.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.serviceengine.dispatcher.IServiceDispatcher;
import com.openappengine.serviceengine.engine.IGenericServiceEngine;

/**
 * @author hrishi
 *
 */
public class ServiceContext implements ApplicationContextAware {

	/* Generic Service Engine Constant*/
	private static final String GENERIC_SERVICE_ENGINE = "genericServiceEngine";
	
	/* Generic Service Dispatcher Constant*/
	private static final String GENERIC_SERVICE_DISPATCHER = "genericServiceDispatcher";
	
	private static final String MODEL_SERVICE_READER = "modelServiceReader";
	
	/*  ServiceContextProvider */
	private static ServiceContextProvider serviceContextProvider;
	
	/**
	 * @return GenericServiceEngine - from ServiceEngineContext
	 */
	public static IGenericServiceEngine getGenericServiceEngine() {
		return (IGenericServiceEngine) serviceContextProvider.getBean(GENERIC_SERVICE_ENGINE);
	}
	
	/**
	 * @return IServiceDispatcher getGenericServiceEngine from the ServiceEngineContext
	 */
	public static IServiceDispatcher getServiceDispatcher() {
		return (IServiceDispatcher) serviceContextProvider.getBean(GENERIC_SERVICE_DISPATCHER);
	}
	
	/*public static ModelServiceReader getModelServiceReader() {
		return (ModelServiceReader) serviceContextProvider.getBean(MODEL_SERVICE_READER);
	}*/
	
	private class ServiceContextProvider {
		
		private ApplicationContext applicationContext;
		
		private ServiceContextProvider(ApplicationContext applicationContext) {
			this.applicationContext = applicationContext;
		}
		
		public Object getBean(String beanName) {
			return applicationContext.getBean(beanName);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ServiceContext.serviceContextProvider = new ServiceContextProvider(context);
	}

}
