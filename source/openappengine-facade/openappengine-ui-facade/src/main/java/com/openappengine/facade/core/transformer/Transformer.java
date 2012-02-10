/**
 * 
 */
package com.openappengine.facade.core.transformer;

import com.openappengine.facade.core.xml.transformer.StringTypeConverter;

/**
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
	
	void registerCustomConverters(Class<?> forClass,StringTypeConverter converter);

}
