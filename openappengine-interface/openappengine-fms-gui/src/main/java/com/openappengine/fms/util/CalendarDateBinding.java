/**
 * 
 */
package com.openappengine.fms.util;

import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.wtk.Calendar.SelectedDateBindMapping;

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
			Date date = new Date();
			date = DateUtils.setDays(date, calendarDate.day);
			date = DateUtils.setMonths(date, calendarDate.month);
			date = DateUtils.setYears(date, calendarDate.year);
			return date;
		}
		return null;
	}

}
