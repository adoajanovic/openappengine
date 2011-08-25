/**
 * 
 */
package com.ms.openapps.servicedef.api;

import org.w3c.dom.Document;

import com.ms.openapps.service.context.DispatchContext;

/**
 * @author hrishi
 * 
 */
public interface IServiceDef {
	
	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc);
	
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc);
	
	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc);
}
