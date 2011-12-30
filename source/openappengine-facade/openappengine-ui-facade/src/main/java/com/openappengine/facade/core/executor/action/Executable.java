/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * @author hrishi
 *
 */
public interface Executable {

	Object execute(ScreenApplicationContext screenContext);
	
}
