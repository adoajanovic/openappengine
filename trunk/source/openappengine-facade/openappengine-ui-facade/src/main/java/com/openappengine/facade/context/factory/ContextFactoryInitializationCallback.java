/**
 * 
 */
package com.openappengine.facade.context.factory;


/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class ContextFactoryInitializationCallback implements Callback<ScreenApplicationContextFactory> {
	
	@Override
	public ScreenApplicationContextFactory onCallback() {
		return createFactory();
	}
	
	protected abstract ScreenApplicationContextFactory createFactory();

}
