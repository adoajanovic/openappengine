/**
 * 
 */
package com.openappengine.gui.engine.core.context;


/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public interface GuiContextPostProcessor {
	
	/**
	 * Perform Post Processing on the GUI Context after initializations.
	 * 
	 * @param context
	 * @return the original context or wrapped/post-processed context instance.
	 */
	GuiEngineContext postProcessGuiContext(GuiEngineContext context);

}
