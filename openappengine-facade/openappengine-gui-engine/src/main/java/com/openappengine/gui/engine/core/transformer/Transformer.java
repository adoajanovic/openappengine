/**
 * 
 */
package com.openappengine.gui.engine.core.transformer;

import com.openappengine.gui.engine.core.xml.transformer.StringConverter;

/**
 * The Transformer API is used primarily for Message Transformation between GUI Engine 
 * and Other Engines.   
 * 
 * @author hrishikesh.joshi
 * @since  Feb 10, 2012
 *
 */
public interface Transformer<T, O> {
	
	/**
	 * Transform from input type T to output type O.
	 * @param t
	 * @return
	 */
	O transform(T t);
	
	void registerCustomConverters(Class<?> forClass,StringConverter converter);

}
