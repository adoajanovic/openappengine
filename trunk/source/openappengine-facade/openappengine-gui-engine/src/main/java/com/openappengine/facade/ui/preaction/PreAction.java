/**
 * 
 */
package com.openappengine.facade.ui.preaction;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.executor.action.Executable;

/**
 * @author hrishi
 *
 */
public abstract class PreAction implements Executable {

	public abstract Object execute(GuiApplicationContext screenContext);
	
}
