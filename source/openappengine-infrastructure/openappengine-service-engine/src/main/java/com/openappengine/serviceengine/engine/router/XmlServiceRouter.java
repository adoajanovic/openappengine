/**
 * 
 */
package com.openappengine.serviceengine.engine.router;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.w3c.dom.Document;

import com.ms.openapps.util.UtilXml;
import com.openappengine.serviceengine.ServiceReaderUtils;
import com.openappengine.serviceengine.constants.ParameterConstants;
import com.openappengine.serviceengine.context.DispatchContext;

/**
 * @author hrishi
 *
 */
public class XmlServiceRouter {
	
	private static final String ELEMENT_PHASE = "Phase";

	private Class<?> serviceClass;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private static final String PERFORM_PRE_PROCESSING = "performPreProcessing";
	
	private static final String PERFORM_POST_PROCESSING = "performPostProcessing";
	
	private static final String PERFORM_PROCESSING = "performProcessing";
	
	public XmlServiceRouter(Class<?> serviceClass) throws XmlServiceRouterException {
		validateClass(serviceClass);
		this.serviceClass = serviceClass;
	}

	private void validateClass(Class<?> serviceClass) throws XmlServiceRouterException {
		if(serviceClass == null) {
			throw new XmlServiceRouterException("Service Name cannot be null!");
		}
	}
	
	public Object invokeXmlService(DispatchContext dispatchContext, Object context) throws XmlServiceRouterException {
		try {
			Object newInstance = serviceClass.newInstance();
			logger.info("Performing Pre-Processing..");
			Document initContext = (Document) context;
			//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PRE_PROCESSING_PHASE_STARTED);
			Document preProcessResult = invokePreProcesserMethod(dispatchContext, initContext, newInstance);
			if(preProcessResult != null) {
				//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PRE_PROCESSING_PHASE_COMPLETE);
				String response = checkProcessingResult(preProcessResult);
				if(!serviceFailed(response)) {
					logger.info("Performing Processing..");
					//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PROCESSING_PHASE_STARTED);
					Method processorMethod = getProcessorMethod(dispatchContext, preProcessResult);
					Document processingResult = (Document) processorMethod.invoke(newInstance, dispatchContext,preProcessResult);
					if(processingResult != null) {
						//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PROCESSING_PHASE_COMPLETE);
						String processingResponse = checkProcessingResult(processingResult);
						if(!serviceFailed(processingResponse)) {
							Method postProcessorMethod = getPostProcessorMethod(dispatchContext, processingResult);
							logger.info("Performing Post-Processing..");
							//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PROCESSING_PHASE_STARTED);
							Document postProcessorResult = (Document) postProcessorMethod.invoke(newInstance, dispatchContext,processingResult);
							String postProcessingResponse = checkProcessingResult(postProcessorResult);
							//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.PROCESSING_PHASE_COMPLETE);
							if(!serviceFailed(postProcessingResponse)) {
								logger.info("Service Completed");
								UtilXml.removeSingleNode(postProcessorResult, ParameterConstants.SERVICE_RESPONSE);
								return postProcessorResult;
							} else {
								//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.ERROR);
								logger.info("Service Post-Processing returned error..");
							}
						} else {
							//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.ERROR);
							logger.info("Service Processing returned error..");		
						}
					}
				} else {
					//UtilXml.updateSingleElement(initContext.getDocumentElement(),ELEMENT_PHASE, ""+ServicePhases.ERROR);
					logger.info("Service Pre-Processing returned error..");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new XmlServiceRouterException("Exception encountered while executing the Service.");
		}
		return context;
	}

	/**
	 * @param response
	 * @param processingResponse
	 * @return
	 */
	private boolean serviceFailed(String response) {
		return ParameterConstants.SERVICE_FAILED.equalsIgnoreCase(response);
	}

	/**
	 * @param preProcessResult
	 * @return
	 */
	private String checkProcessingResult(Document preProcessResult) {
		String response = UtilXml.childElementValue(preProcessResult.getDocumentElement(), ParameterConstants.SERVICE_RESPONSE);
		return response;
	}

	/**
	 * @param dispatchContext
	 * @param context
	 * @param newInstance
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private Document invokePreProcesserMethod(DispatchContext dispatchContext,
			Object context, Object newInstance) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method preprocessMethod = getPreProcessorMethod(dispatchContext,context);
		Document preProcessResult = (Document) preprocessMethod.invoke(newInstance, dispatchContext,context);
		return preProcessResult;
	}

	/**
	 * @param dispatchContext
	 * @param context
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private Method getPreProcessorMethod(DispatchContext dispatchContext,
			Object context) throws NoSuchMethodException, SecurityException {
		Method preprocessMethod = getServiceRouterMethod(dispatchContext,context,PERFORM_PRE_PROCESSING);
		return preprocessMethod;
	}
	
	/**
	 * @param dispatchContext
	 * @param context
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private Method getPostProcessorMethod(DispatchContext dispatchContext,
			Object context) throws NoSuchMethodException, SecurityException {
		Method preprocessMethod = getServiceRouterMethod(dispatchContext,context,PERFORM_POST_PROCESSING);
		return preprocessMethod;
	}
	
	/**
	 * @param dispatchContext
	 * @param context
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private Method getProcessorMethod(DispatchContext dispatchContext,
			Object context) throws NoSuchMethodException, SecurityException {
		Method preprocessMethod = getServiceRouterMethod(dispatchContext,context,PERFORM_PROCESSING);
		return preprocessMethod;
	}
	
	private Method getServiceRouterMethod(DispatchContext dispatchContext,
			Object context,String methodName) throws NoSuchMethodException, SecurityException {
		Method xmlServiceRunnerMethod = ServiceReaderUtils.getXmlServiceRunnerMethod(methodName,serviceClass);
		return xmlServiceRunnerMethod;
	}
	
	
}
