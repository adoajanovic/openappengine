/**
 * 
 */
package com.openappengine.facade.ui.action;

import com.openappengine.facade.ui.context.ScreenContext;

/**
 * @author hrishi
 *
 */
public interface Executable {

	Object execute(ScreenContext screenContext);
	
}
