/**
 * 
 */
package com.openappengine.utility;

import java.util.Map;

import javolution.util.FastMap;

/**
 * @author hrishi
 *
 */
public class UtilGenerics {
	
	/**
	 * @param <String>
	 * @param <Object>
	 * @return FastMap
	 */
	public static Map<String, Object> getFastMap() {
		Map<String,Object> result = new FastMap<String, Object>();
		return result;
	}
	

}
