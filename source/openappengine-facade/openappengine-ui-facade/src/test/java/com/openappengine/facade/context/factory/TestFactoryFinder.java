/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.apache.commons.collections.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for the FactoryFinder module.
 * @author hrishi
 * since Dec 31, 2011
 */
public class TestFactoryFinder {
	
	@Test
	public void testFindFactoryInstance() {
		Factory factory = FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
		Assert.assertNotNull("Factory not initialized inspite of the InitializationCallback provided.",factory);
		Factory factoryR = FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, null);
		Assert.assertNotNull("Factory not initialized inspite of the InitializationCallback provided.",factoryR);
		Assert.assertEquals(factory, factoryR);
	}

}
