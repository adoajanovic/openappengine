/**
 * 
 */
package com.openappengine.facade.core.executor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.executor.action.ActionHandler;

/**
 * @author hrishi
 * since Feb 7, 2012
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	
	String actionName();
	
	//TODO
	//Class<? extends ActionHandler<? extends ActionRequestXml>> actionHandlerClass();
}
