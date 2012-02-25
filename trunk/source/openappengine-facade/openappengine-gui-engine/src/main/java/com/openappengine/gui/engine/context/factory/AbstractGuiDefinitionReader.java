/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractGuiDefinitionReader implements GuiDefinitionReader {

	@Override
	public GuiRootComponent loadScreenDefinition(Resource resource) {
		Assert.notNull(resource,"Resource cannot be null.");
		try {
			return loadScreenDefinition(resource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException("Exception encountered while reading the screen definition.",e);
		}
	}

	protected abstract GuiRootComponent loadScreenDefinition(InputStream inputStream);
	
}
