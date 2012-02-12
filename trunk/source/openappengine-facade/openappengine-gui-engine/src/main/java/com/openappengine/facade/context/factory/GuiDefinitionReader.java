package com.openappengine.facade.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.ui.GuiRootComponent;

/**
 * @author hrishi
 * since Dec 28, 2011
 */
public interface GuiDefinitionReader {
	
	/**
	 * Load Screen Definition from the specified XML file.
	 * @param resource
	 */
	GuiRootComponent loadScreenDefinition(Resource resource);
	
}
