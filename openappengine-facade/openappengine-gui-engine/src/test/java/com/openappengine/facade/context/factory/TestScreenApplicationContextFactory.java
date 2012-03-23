/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;

import com.openappengine.gui.engine.context.factory.FactoryConstants;
import com.openappengine.gui.engine.context.factory.FactoryFinder;
import com.openappengine.gui.engine.context.factory.GuiContextFactory;
import com.openappengine.gui.engine.context.factory.WebContextFactoryInitializationCallback;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.ext.ExternalWebContext;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class TestScreenApplicationContextFactory {
	
	private GuiContextFactory screenApplicationContextFactory;

	@Before
	public void setup() {
		ApplicationContext c = new ClassPathXmlApplicationContext("entity-facade-context.xml");
		screenApplicationContextFactory = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
		Assert.assertNotNull("ScreenApplicationContextFactory Null !", screenApplicationContextFactory);
	}
	
	@Test
	public void testGetScreenApplicationContext() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("CodeType.xml");
		Assert.assertNotNull("InputStream cannot be null.",inputStream);
		Resource resource = new InputStreamResource(inputStream);
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("codeTypeId", "1");
		ExternalContext externalContext = new ExternalWebContext(request);
		
		GuiEngineContext applicationContext = screenApplicationContextFactory.createGuiEngineContext(resource);
		Assert.assertNotNull("GuiEngineContext instance could not be created.",applicationContext);
	}

}
