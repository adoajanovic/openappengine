package com.openappengine.gui.engine.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;

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
