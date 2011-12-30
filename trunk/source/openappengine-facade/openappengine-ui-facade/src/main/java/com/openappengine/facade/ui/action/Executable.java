/**
 * 
 */
package com.openappengine.facade.ui.action;

import com.openappengine.facade.ui.core.context.ScreenApplicationContext;

/**
 * @author hrishi
 *
 */
public interface Executable {

	Object execute(ScreenApplicationContext screenContext);
	
}
