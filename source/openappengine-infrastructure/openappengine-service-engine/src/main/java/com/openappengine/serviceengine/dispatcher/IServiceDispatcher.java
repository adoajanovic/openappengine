/**
 * 
 */
package com.openappengine.serviceengine.dispatcher;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.engine.GenericServiceException;

/**
 * @author hrishi
 *
 */
public interface IServiceDispatcher {
	
	/**
	 *  Run the service
	 * @param name
	 * @param params
	 * @return Map - return values as Map
	 * @throws GenericServiceException 
	 */
	public Map<String,Object> runService(String name,Map<String,Object> params) throws GenericServiceException;
	
	/**
	 * @param name
	 * @param params
	 * @return Documeny
	 * @throws GenericServiceException
	 */
	public Document runXmlService(String name,Document params) throws GenericServiceException;
	
	/**
	 *  Run the service and ignore the result.
	 * @param name
	 * @param params
	 * @throws GenericServiceException 
	 */
	public void runServiceIgnore(String name,Map<String,Object> params) throws GenericServiceException;
	
	
	/**
	 *   Run the XML service and ignore the result.
	 * @param name
	 * @param params
	 * @throws GenericServiceException
	 */
	public void runXmlServiceIgnoreResult(String name,Document params) throws GenericServiceException;
	

}
