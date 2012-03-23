/**
 * 
 */
package com.openappengine.entity.processor;

import com.openappengine.entity.request.EntityRequest;
import com.openappengine.entity.response.EntityResponse;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public interface EntityEngineRequestProcessor {
	
	EntityResponse process(EntityRequest request);

}
