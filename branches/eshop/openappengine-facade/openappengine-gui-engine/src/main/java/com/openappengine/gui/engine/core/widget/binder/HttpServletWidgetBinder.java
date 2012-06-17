/**
 * 
 */
package com.openappengine.gui.engine.core.widget.binder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

/**
 * HttpServletWidgetBinder is an interface to bind the submitted values to the FormWidget 
 * and raise binding error messages, if in-appropriate values are present in the
 * submitted widget.
 * 
 * @author hrishi
 * since Feb 12, 2012
 */
public interface HttpServletWidgetBinder {
	
	void bind(HttpServletRequest request);
	
	boolean hasErrors();
	
	BindingResult getBindingResult();
}
