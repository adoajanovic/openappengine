/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openappengine.gui.engine.context.factory.FactoryConstants;
import com.openappengine.gui.engine.context.factory.FactoryFinder;
import com.openappengine.gui.engine.context.factory.GuiContextFactory;
import com.openappengine.gui.engine.context.factory.WebContextFactoryInitializationCallback;

/**
 * Test Class for the FactoryFinder module.
 * @author hrishi
 * since Dec 31, 2011
 */
public class TestFactoryFinder {
	
	private GuiContextFactory screenApplicationContextFactory;

	@Before
	public void createFactory() {
		screenApplicationContextFactory = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
	}
	
	@Test
	public void testFindFactoryInstance() {
		Assert.assertNotNull("Factory not initialized inspite of the InitializationCallback provided.",screenApplicationContextFactory);
		
		//Create a new Screen Application Context Factory without a callback. As we have already created one this should not be null
		//even if NO initializer callbacks are provided.
		GuiContextFactory factoryR = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, null);
		Assert.assertNotNull("Factory not initialized inspite of the InitializationCallback provided.",factoryR);
		Assert.assertEquals(screenApplicationContextFactory, factoryR);
	}
	
	@Test
	public void testFactoryFinderWithInvalidFactoryName() {
		boolean containsFactory = FactoryFinder.containsFactory("InvalidFactory");
		
		if(!containsFactory) {
			GuiContextFactory factory = (GuiContextFactory) FactoryFinder.getFactory("InvalidFactory", null);
			//As no callback initializer is provided this should return a null.
			Assert.assertNull("Factory should be Null, if the FactoryFinder doesnt have the named factory and no callback instance is provided.",factory);
		}
	}

}
