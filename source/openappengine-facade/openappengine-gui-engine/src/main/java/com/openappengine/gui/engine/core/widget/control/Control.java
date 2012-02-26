/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Control {

	String widgetControlName();
	
	boolean rendersChildren() default false;
}
