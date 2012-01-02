/**
 * 
 */
package com.openappengine.facade.context.factory;


/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class ContextFactoryInitializationCallback implements Callback<GuiContextFactory> {
	
	@Override
	public GuiContextFactory onCallback() {
		return createFactory();
	}
	
	protected abstract GuiContextFactory createFactory();

}
