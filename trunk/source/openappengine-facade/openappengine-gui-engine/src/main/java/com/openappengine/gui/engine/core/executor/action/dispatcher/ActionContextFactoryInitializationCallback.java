/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.dispatcher;

import com.openappengine.gui.engine.context.factory.Callback;
import com.openappengine.gui.engine.core.executor.action.context.ActionContextFactory;
import com.openappengine.gui.engine.core.executor.action.context.DefaultActionContextFactory;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class ActionContextFactoryInitializationCallback implements Callback<ActionContextFactory> {

	@Override
	public ActionContextFactory onCallback() {
		return new DefaultActionContextFactory();
	}

}
