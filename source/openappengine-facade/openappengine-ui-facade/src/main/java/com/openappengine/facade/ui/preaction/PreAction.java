/**
 * 
 */
package com.openappengine.facade.ui.preaction;

import com.openappengine.facade.ui.action.Executable;
import com.openappengine.facade.ui.core.context.ScreenApplicationContext;

/**
 * @author hrishi
 *
 */
public abstract class PreAction implements Executable {

	public abstract Object execute(ScreenApplicationContext screenContext);
	
}
