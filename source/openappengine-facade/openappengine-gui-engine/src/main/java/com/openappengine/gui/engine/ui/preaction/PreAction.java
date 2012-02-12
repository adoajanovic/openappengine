/**
 * 
 */
package com.openappengine.gui.engine.ui.preaction;

import com.openappengine.gui.engine.core.context.GuiApplicationContext;
import com.openappengine.gui.engine.core.executor.action.Executable;

/**
 * @author hrishi
 *
 */
public abstract class PreAction implements Executable {

	public abstract Object execute(GuiApplicationContext screenContext);
	
}
