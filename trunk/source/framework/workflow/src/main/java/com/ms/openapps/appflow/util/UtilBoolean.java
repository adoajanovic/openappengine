/**
 * 
 */
package com.ms.openapps.appflow.util;

/**
 * @author hrishi
 *
 */
public class UtilBoolean {
	
	private static boolean parseNonNullString(String booleanString) {
		boolean result = Boolean.parseBoolean(booleanString);
		return result;
	}
	
	/**
	 *  Return Boolean from String
	 * @param booleanString
	 * @return boolean value
	 * @throws Exception
	 */
	public static boolean parseStringAsBoolean(String booleanString) throws Exception {
		if(booleanString == null || booleanString.length() == 0)
			throw new Exception("Input cannot be null or empty");
		return parseNonNullString(booleanString);
	}

}
