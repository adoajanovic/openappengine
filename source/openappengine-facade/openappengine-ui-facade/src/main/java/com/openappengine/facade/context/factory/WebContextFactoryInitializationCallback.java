/**
 * 
 */
package com.openappengine.facade.context.factory;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class WebContextFactoryInitializationCallback extends ContextFactoryInitializationCallback {
	
	private ContextConfiguration contextConfiguration;
	
	public WebContextFactoryInitializationCallback() {
	}

	public WebContextFactoryInitializationCallback(ContextConfiguration contextConfiguration) {
		super();
		this.contextConfiguration = contextConfiguration;
	}

	@Override
	protected ScreenApplicationContextFactory createFactory() {
		validateContextConfiguration();
		ScreenApplicationContextFactory factory = new XmlScreenApplicationContextFactory(getContextConfiguration());
		return factory;
	}

	protected void validateContextConfiguration() {
		if(contextConfiguration == null) {
			//TODO - Change this to DefaultWebContextConfiguration here.
			contextConfiguration = new DefaultContextConfiguration();
		}
	}

	public ContextConfiguration getContextConfiguration() {
		return contextConfiguration;
	}

	public void setContextConfiguration(ContextConfiguration contextConfiguration) {
		this.contextConfiguration = contextConfiguration;
	}

}
