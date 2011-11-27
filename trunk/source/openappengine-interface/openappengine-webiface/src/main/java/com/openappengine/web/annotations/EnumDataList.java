/**
 *  Use this annotation on a field which should be populated from an Enum.
 */
package com.openappengine.web.annotations;

/**
 * @author hrishi
 *
 */
@ListItem
public @interface EnumDataList {

    public Class<?> enumClass();
}
