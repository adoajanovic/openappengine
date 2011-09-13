/**
 * 
 */
package com.ms.openapps.util;

/**
 * @author hrishi
 *
 */
public class UtilString {
	
	/**
	 *  Checks if the input String is empty or blank. 
	 * @param s
	 * @return boolean
	 */
	public static boolean isEmptyOrBlank(String s) {
		if(s == null || s.isEmpty()) {
			return true;
		}
		return false;
	}

}
