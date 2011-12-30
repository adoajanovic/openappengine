/**
 * 
 */
package com.openappengine.facade.ui.action.entity;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.ui.action.Executable;
import com.openappengine.facade.ui.context.ScreenApplicationContext;

/**
 * @author hrishi
 *
 */
public abstract class EntityAction implements Executable {
	
	public abstract EntityValue execute(ScreenApplicationContext screenContext);

}
