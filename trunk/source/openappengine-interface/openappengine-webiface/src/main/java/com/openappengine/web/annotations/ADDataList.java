/**
 * 
 */
package com.openappengine.web.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * @author hrishi
 *
 */

@ListItem
@Retention(RetentionPolicy.RUNTIME)
public @interface ADDataList {

    public String type();
}
