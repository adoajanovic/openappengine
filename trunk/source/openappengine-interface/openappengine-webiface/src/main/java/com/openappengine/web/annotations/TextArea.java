/**
 *  The String property annoted with {@link TextArea} will render a Text Area for that property.
 */
package com.openappengine.web.annotations;

/**
 * @author hrishikesh.joshi
 *
 */
public @interface TextArea {

	public int length = 255;
	
	public boolean richText = false;
}
