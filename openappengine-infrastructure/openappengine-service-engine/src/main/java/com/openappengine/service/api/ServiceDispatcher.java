/**
 * 
 */
package com.openappengine.service.api;

import java.util.Map;

/**
 * <code>ServiceDispatcher</code> interface is used to decouple the
 * Callers from the Services (<code>ModelService</code>). The general
 * usage of this interface would be to pass a Service Name and input parameters
 * to run/execute the particular service.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public interface ServiceDispatcher {
	
	Map<String, Object> runSync(String serviceName,Map<String, Object> context) throws ServiceException;

	void runSyncIgnoreResult(String serviceName,Map<String, Object> context) throws ServiceException;

}
