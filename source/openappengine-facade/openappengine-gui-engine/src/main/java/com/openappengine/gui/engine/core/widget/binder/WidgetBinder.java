/**
 * 
 */
package com.openappengine.gui.engine.core.widget.binder;

import org.springframework.validation.BindingResult;
import org.w3c.dom.Document;

/**
 * WidgetBinder is an interface to bind the submitted values to the FormWidget 
 * and raise binding error messages, if in-appropriate values are present in the
 * submitted widget.
 * 
 * @author hrishi
 * since Feb 12, 2012
 */
public interface WidgetBinder {
	
	void bind(Document widget);
	
	boolean hasErrors();
	
	BindingResult getBindingResult();

}
