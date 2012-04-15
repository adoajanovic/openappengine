/**
 * 
 */
package com.openappengine.fms.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.wtk.Calendar.SelectedDateBindMapping;

import com.openappengine.utility.DateTimeUtil;

/**
 * @author hrishi
 *
 */
public class CalendarDateBinding implements SelectedDateBindMapping {

	@Override
	public CalendarDate toDate(Object value) {
		if(value instanceof Date) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime((Date) value);
			CalendarDate calendarDate = new CalendarDate(calendar);
			return calendarDate;
		}
		return null;
	}

	@Override
	public Object valueOf(CalendarDate calendarDate) {
		if(calendarDate !=  null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DATE, calendarDate.day + 1);
			calendar.set(Calendar.MONTH, calendarDate.month);
			calendar.set(Calendar.YEAR, calendarDate.year);
			return calendar.getTime();
		}
		return null;
	}

}
