/**
 * 	This class will have all the static methods (utility methods)
 */
package com.openappengine.serviceengine;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.constants.ParameterConstants;
import com.openappengine.utility.UtilGenerics;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class ServiceUtil {
	
	/**
	 * @param params
	 * @param message
	 * @return Puts the ErrorMessage = message and ErrorStatus = FAIL in the Params Map and returns back the Params map.
	 */
	public static Map<String,Object> returnError(Map<String,Object> params,String message){
		if(params == null) {
			params = UtilGenerics.getFastMap();
		} 
		params.put(ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_FAILED);
		params.put(ParameterConstants.SERVICE_ERROR_MESSAGE, message);
		return params;
	}
	
	public static Document returnError(Document params, String message) {
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_FAILED, params);
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_ERROR_MESSAGE, message, params);
		return params;
	}
	
	/**
	 * @param params
	 * @return Puts the Status = SUCCESS in the Params Map and returns back the Params map.
	 */
	public static Map<String,Object> returnSuccess(Map<String,Object> params){
		if(params == null) {
			params = UtilGenerics.getFastMap();
		} 
		params.put(ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_SUCCESS);
		return params;
	}
	
	public static Document returnSuccess(Document params, String message) {
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_RESPONSE, ParameterConstants.SERVICE_SUCCESS, params);
		UtilXml.addChildElementValue(params.getDocumentElement(), ParameterConstants.SERVICE_ERROR_MESSAGE, message, params);
		return params;
	}

}
