/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.core.executor.action.context.ActionContextFactory;
import com.openappengine.facade.core.executor.action.context.DefaultActionContextFactory;

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
