/**
 * 
 */
package com.ms.openapps.service.engine;

import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.service.ModelService;

/**
 * @author hrishi
 *
 */
public interface IGenericServiceEngine {
	
	public Map<String, Object> runService(ModelService modelService,Map<String, ? extends Object> params) throws GenericServiceException;
	
	public Document runXmlService(ModelService modelService,Document params) throws GenericServiceException;

	public void runServiceIgnoreResult(ModelService modelService,Map<String,? extends Object> context) throws GenericServiceException;
	
	public void runXmlServiceIgnoreResult(ModelService modelService,Document params) throws GenericServiceException;
	
}
