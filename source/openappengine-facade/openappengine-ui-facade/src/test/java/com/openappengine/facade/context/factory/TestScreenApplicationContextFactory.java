/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class TestScreenApplicationContextFactory {
	
	private GuiContextFactory screenApplicationContextFactory;

	@Before
	public void setup() {
		screenApplicationContextFactory = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
		Assert.assertNotNull("ScreenApplicationContextFactory Null !", screenApplicationContextFactory);
	}
	
	@Test
	public void testGetScreenApplicationContext() {
		ClassPathResource resource = new ClassPathResource("CodeType.xml");
		GuiApplicationContext applicationContext = screenApplicationContextFactory.createGuiApplicationContext(resource, null);
		
	}

}
