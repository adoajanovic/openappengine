/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;

import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.ext.ExternalWebContext;

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
		InputStream inputStream = getClass().getResourceAsStream("CodeType.xml");
		Resource resource = new InputStreamResource(inputStream);
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("codeTypeId", "1");
		ExternalContext externalContext = new ExternalWebContext(request);
		
		GuiApplicationContext applicationContext = screenApplicationContextFactory.createGuiApplicationContext(resource, externalContext);
		
	}

}
