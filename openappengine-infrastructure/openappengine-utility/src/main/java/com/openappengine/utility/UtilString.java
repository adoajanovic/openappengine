/**
 * 
 */
package com.openappengine.utility;

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
	
	/**
	 * @param s
	 * @return boolean from String
	 */
	public static boolean convertToBoolean(String s) {
		if(s == null || s.isEmpty()) {
			return false;
		}
		boolean b = false;
		try {
		b = Boolean.parseBoolean(s);
		} catch (Exception e) {
			return false;
		}
		return b;
	}

}
