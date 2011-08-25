/**
 * 
 */
package com.ms.openapps.service.facade;

import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.service.context.ServiceContext;
import com.ms.openapps.service.dispatcher.IServiceDispatcher;
import com.ms.openapps.service.engine.GenericServiceException;
import com.ms.openapps.util.UtilLogger;

/**
 * @author hrishi
 *
 */
public class ServiceFacade {

	private static UtilLogger logger = new UtilLogger(ServiceFacade.class);
	
	/**
	 *  Call ServiceEngine with the given ServiceName and pass the input parameters 
	 * @param serviceName
	 * @param parameters
	 * @return output params returned from ServiceEngine
	 */
	public static Map<String, Object> callService(String serviceName,Map<String,Object> parameters) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		Map<String, Object> output = null;
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 output = serviceDispatcher.runService(serviceName, parameters);
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Document callXmlService(String serviceName,Document parameters) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		Document output = null;
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 output = serviceDispatcher.runXmlService(serviceName, parameters);
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	
	/**
	 *  Call ServiceEngine with the given ServiceName and pass the input parameters and ignore the result
	 * @param serviceName
	 * @param parameters
	 */
	public static void callServiceIgnoreResult(String serviceName,Map<String,Object> parameters) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 serviceDispatcher.runServiceIgnore(serviceName, parameters);
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Call ServiceEngine with the given ServiceName and pass the input parameters and ignore the result
	 * @param serviceName
	 * @param parameters
	 */
	public static void callXmlServiceIgnoreResult(String serviceName,Document parameters) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 serviceDispatcher.runXmlServiceIgnoreResult(serviceName, parameters);
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
	}
	
	
}
