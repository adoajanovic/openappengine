/**
 * 
 */
package com.ms.openapps.oxm.converter;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.ms.openapps.oxm.beans.PayloadData;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.javabean.JavaBeanConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author hrishikesh
 * 
 */
public class RequestPayloadDataConverter implements Converter {

	private static final List<String> IGNORE_FIELDS;
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	private RequestPayloadDataMapper dataMapper;

	private JavaBeanConverter javaBeanConverter;

	private CollectionConverter collectionConverter;
	
	static {
		IGNORE_FIELDS = new ArrayList<String>();
		IGNORE_FIELDS.add("serialVersionUID");
	}
	
	public RequestPayloadDataConverter() {
		dataMapper = new RequestPayloadDataMapper(getClass().getClassLoader());
		javaBeanConverter = new JavaBeanConverter(dataMapper);
		collectionConverter = new CollectionConverter(dataMapper);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.
	 * lang.Class)
	 */
	@Override
	public boolean canConvert(Class cls) {
		return PayloadData.class.isAssignableFrom(cls);
	}
	
	private String writeNodeValues(MarshallingContext marshallingContext,Object object,Field field) {
		if(object == null) {
			return "";
		}
		Class<?> type = field.getType();
		if (Date.class.isAssignableFrom( type )) {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            return dateFormat.format(object);
        }
		if (Collection.class.isAssignableFrom( type )) {
			marshallingContext.convertAnother(object,collectionConverter);
            return "";
        }
		marshallingContext.convertAnother(object);
		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object,
	 * com.thoughtworks.xstream.io.HierarchicalStreamWriter,
	 * com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
		
		Class<?> payloadDataClass = value.getClass();
		Field[] fields = payloadDataClass.getDeclaredFields();
		if (fields != null) {
			for (Field field : fields) {
				String fieldName = field.getName();
				if (!IGNORE_FIELDS.contains(fieldName)) {
					field.setAccessible(true);
					writer.startNode(fieldName);
					try {
						Object object = field.get(value);
						writer.setValue(writeNodeValues(marshallingContext, object, field));
					} catch (Exception e) {
						logger.severe("Cannot Write Tag " + fieldName + " for class " + payloadDataClass.getName());
					}
					writer.endNode();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks
	 * .xstream.io.HierarchicalStreamReader,
	 * com.thoughtworks.xstream.converters.UnmarshallingContext)
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
		String clazz = reader.getAttribute("class");
		Object unmarshalledObj = null;
		try {
			Class<?> unmarshalledClass = Class.forName(clazz);
			unmarshalledObj = unmarshalledClass.newInstance();
			Field[] fields = unmarshalledClass.getDeclaredFields();
			if(fields != null) {
				while(reader.hasMoreChildren()) {
					reader.moveDown();
					String node = reader.getNodeName();
					Field field = unmarshalledClass.getDeclaredField(node);
					field.setAccessible(true);
					Class<?> fieldType = field.getType();
					String stringValue = reader.getValue();
					Object value = unmarshallingContext.convertAnother(stringValue, fieldType);
					field.set(unmarshalledObj, value);
					reader.moveUp();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unmarshalledObj;
	}

}
