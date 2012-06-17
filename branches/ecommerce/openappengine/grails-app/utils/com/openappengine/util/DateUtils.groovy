/**
 * 
 */
package com.openappengine.util

/**
 * @author hrishikesh.joshi
 *
 */
class DateUtils {
	
	public static boolean isDateBetweenTwoDatesInclusive(Date fromDate, Date toDate, Date aspectDate) {
		if ((aspectDate.after(fromDate) || aspectDate.equals(fromDate))
				&& (aspectDate.before(toDate) || aspectDate.equals(toDate))) {
			return true;
		}
		return false;
	}

}
