/**
 * 
 */
package com.openappengine.web.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author hrishikesh.joshi
 *
 */
@ListItem
@Retention(RetentionPolicy.RUNTIME)
public @interface ADAutocomplete {

	public String type();
}
