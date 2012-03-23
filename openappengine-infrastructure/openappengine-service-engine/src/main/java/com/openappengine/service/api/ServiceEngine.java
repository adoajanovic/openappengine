/**
 * 
 */
package com.openappengine.service.api;

import java.util.Map;

import com.openappengine.service.model.ModelService;

/**
 * The <code>ServiceEngine</code> API is responsible for 
 * executing <code>Service</code> sync/async, with the parameters
 * passed to it.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public interface ServiceEngine {
	
	Map<String, Object> runSync(ModelService modelService,Map<String, Object> context) throws ServiceException;

	void runSyncIgnoreResult(ModelService modelService,Map<String, Object> context) throws ServiceException;
}
