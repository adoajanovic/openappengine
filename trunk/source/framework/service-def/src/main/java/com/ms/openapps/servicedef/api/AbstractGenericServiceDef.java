/**
 * 
 */
package com.ms.openapps.servicedef.api;

import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.service.constants.ParameterConstants;
import com.ms.openapps.util.UtilGenerics;
import com.ms.openapps.util.UtilXml;


/**
 * @author hrishi
 *
 */
public abstract class AbstractGenericServiceDef implements IServiceDef {

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
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_ERROR_MESSAGE, message, params);
		return params;
	}
}
