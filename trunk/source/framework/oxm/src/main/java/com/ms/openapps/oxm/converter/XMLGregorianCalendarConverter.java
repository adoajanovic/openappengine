/**
 * 
 */
package com.ms.openapps.oxm.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author hrishi
 * 
 */
public class XMLGregorianCalendarConverter implements Converter {

	public XMLGregorianCalendarConverter() {
		super();
	}

	public boolean canConvert(Class clazz) {
		return XMLGregorianCalendar.class.isAssignableFrom(clazz);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		XMLGregorianCalendar xmlGregorianCalendar = (XMLGregorianCalendar) value;
		Date date = UtilXMLGregorianCalendar.asDate(xmlGregorianCalendar);
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
		writer.setValue(formatter.format(date));
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		GregorianCalendar calendar = new GregorianCalendar();
		XMLGregorianCalendar xmlGregorianCalendar;
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			calendar.setTime(formatter.parse(reader.getValue()));
			xmlGregorianCalendar = UtilXMLGregorianCalendar.asXMLGregorianCalendar(calendar.getTime());
		} catch (ParseException e) {
			throw new ConversionException(e.getMessage(), e);
		}
		return xmlGregorianCalendar;
	}

}
