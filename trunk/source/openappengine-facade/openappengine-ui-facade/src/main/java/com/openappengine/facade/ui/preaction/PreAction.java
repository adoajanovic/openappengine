/**
 * 
 */
package com.openappengine.facade.ui.preaction;

import com.openappengine.facade.ui.action.Executable;
import com.openappengine.facade.ui.context.ScreenContext;

/**
 * @author hrishi
 *
 */
public abstract class PreAction implements Executable {

	public abstract Object execute(ScreenContext screenContext);
	
}
