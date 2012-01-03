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
	protected GuiContextFactory createFactory() {
		createDefaultContextConfigurationIfNull();
		GuiContextFactory factory = new GuiWebApplicationContextFactory(getContextConfiguration());
		return factory;
	}

	protected void createDefaultContextConfigurationIfNull() {
		if(contextConfiguration == null) {
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
