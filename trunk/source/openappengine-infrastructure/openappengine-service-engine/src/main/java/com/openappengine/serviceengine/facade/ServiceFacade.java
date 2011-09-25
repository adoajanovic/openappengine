/**
 * 
 */
package com.openappengine.serviceengine.facade;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.context.ServiceContext;
import com.openappengine.serviceengine.dispatcher.IServiceDispatcher;
import com.openappengine.serviceengine.engine.GenericServiceException;
import com.openappengine.serviceengine.message.ServiceRequestMessageWrapper;
import com.openappengine.serviceengine.message.ServiceResponseMessageWrapper;
import com.openappengine.utility.UtilLogger;

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
	
	public static ServiceResponseMessageWrapper callXmlService(String serviceName,ServiceRequestMessageWrapper requestMessageWrapper) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		Document output = null;
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 output = serviceDispatcher.runXmlService(serviceName, requestMessageWrapper.getXmlRequest());
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
		ServiceResponseMessageWrapper serviceResponseMessageWrapper = new ServiceResponseMessageWrapper(output);
		return serviceResponseMessageWrapper;
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
	public static void callXmlServiceIgnoreResult(String serviceName,ServiceRequestMessageWrapper serviceRequestMessageWrapper) {
		IServiceDispatcher serviceDispatcher = ServiceContext.getServiceDispatcher();
		logger.logInfo("Invoking Service " + serviceName);
		try {
			 serviceDispatcher.runXmlServiceIgnoreResult(serviceName, serviceRequestMessageWrapper.getXmlRequest());
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
	}
	
	
}
