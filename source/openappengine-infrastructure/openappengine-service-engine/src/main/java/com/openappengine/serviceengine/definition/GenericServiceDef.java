/**
 * 
 */
package com.openappengine.serviceengine.definition;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.context.EntityContext;
import com.openappengine.serviceengine.constants.ParameterConstants;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.utility.UtilGenerics;
import com.openappengine.utility.UtilXml;


/**
 * @author hrishi
 *
 */
public class GenericServiceDef implements IServiceDef {
	
	private GenericRepository genericRepository;
	
	public GenericServiceDef() {
		genericRepository = EntityContext.getInstance().getGenericRepository();
	}

	protected GenericRepository getGenericRepository() {
		return genericRepository;
	}
	
	/**
	 * @param params
	 * @param message
	 * @return Puts the ErrorMessage = message and ErrorStatus = FAIL in the Params Map and returns back the Params map.
	 */
	protected Map<String,Object> returnError(Map<String,Object> params,String message){
		if(params == null) {
			params = UtilGenerics.getFastMap();
		} 
		params.put(ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_FAILED);
		params.put(ParameterConstants.SERVICE_ERROR_MESSAGE, message);
		return params;
	}
	
	protected Document returnError(Document params, String message) {
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_FAILED, params);
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_ERROR_MESSAGE, message, params);
		return params;
	}
	
	/**
	 * @param params
	 * @return Puts the Status = SUCCESS in the Params Map and returns back the Params map.
	 */
	protected Map<String,Object> returnSuccess(Map<String,Object> params){
		if(params == null) {
			params = UtilGenerics.getFastMap();
		} 
		params.put(ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_SUCCESS);
		return params;
	}
	
	protected Document returnSuccess(Document params, String message) {
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_SUCCESS, params);
		return params;
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performPreProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if (requestDoc != null) {
			return requestDoc;
		}
		return returnError(requestDoc, "Request Document cannot be null");
	}
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performPostProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if(requestDoc != null) {
			return returnSuccess(requestDoc, "Service Completed..");
		} else {
			return returnError(requestDoc, "Null Response Xml");
		}
	}

	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if (requestDoc != null) {
			return requestDoc;
		}
		return returnError(requestDoc, "Request Document cannot be null");
	}
}
