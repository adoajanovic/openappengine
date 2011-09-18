/**
 * 
 */
package com.openappengine.serviceengine.definition;

import org.w3c.dom.Document;

import com.openappengine.serviceengine.context.DispatchContext;

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
