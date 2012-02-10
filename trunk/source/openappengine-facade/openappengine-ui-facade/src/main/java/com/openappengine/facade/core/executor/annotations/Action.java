/**
 * 
 */
package com.openappengine.facade.core.executor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author hrishi
 * since Feb 7, 2012
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	
	String actionName();
	
}
