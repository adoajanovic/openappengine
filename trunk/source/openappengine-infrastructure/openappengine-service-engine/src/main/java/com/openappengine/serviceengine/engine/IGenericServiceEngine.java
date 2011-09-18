/**
 * 
 */
package com.openappengine.serviceengine.engine;

import java.util.Map;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.model.GenericServiceModel;

/**
 * @author hrishi
 *
 */
public interface IGenericServiceEngine {
	
	public Map<String, Object> runService(GenericServiceModel modelService,Map<String, ? extends Object> params) throws GenericServiceException;
	
	public Document runXmlService(GenericServiceModel modelService,Document params) throws GenericServiceException;

	public void runServiceIgnoreResult(GenericServiceModel modelService,Map<String,? extends Object> context) throws GenericServiceException;
	
	public void runXmlServiceIgnoreResult(GenericServiceModel modelService,Document params) throws GenericServiceException;
	
}
