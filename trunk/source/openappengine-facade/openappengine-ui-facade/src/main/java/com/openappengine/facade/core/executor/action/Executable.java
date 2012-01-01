/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishi
 *
 */
public interface Executable {

	Object execute(GuiApplicationContext screenContext);
	
}
