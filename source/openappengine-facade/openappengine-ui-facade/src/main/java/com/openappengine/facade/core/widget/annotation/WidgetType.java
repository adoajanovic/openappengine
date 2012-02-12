/**
 * 
 */
package com.openappengine.facade.core.widget.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface WidgetType {
	
	String value();

}
