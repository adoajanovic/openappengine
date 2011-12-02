/**
 * 
 */
package com.openappengine.web.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.util.StringUtils;

import com.openappengine.crud.datasource.ADListDataSource;
import com.openappengine.crud.datasource.DataSource;
import com.openappengine.crud.datasource.DataSourceException;
import com.openappengine.crud.datasource.EnumDataSource;
import com.openappengine.web.ad.ADListItem;
import com.openappengine.web.annotations.ADAutocomplete;
import com.openappengine.web.annotations.ADDataList;
import com.openappengine.web.annotations.EnumDataList;
import com.openappengine.web.annotations.ListItem;
import com.openappengine.web.annotations.Required;
import com.openappengine.web.annotations.TextArea;
import com.openappengine.web.exception.ComponentRenderException;

/**
 * @author hrishikesh.joshi
 * 
 */
public class TagUtils {

	private static final Logger LOG = Logger.getLogger(TagUtils.class.getName());

	public static MethodExpression createMethodExpression(FacesContext context, String expr, Class out, Class[] in) {
		return context.getApplication().getExpressionFactory().createMethodExpression(context.getELContext(), expr, out, in);
	}

	public static ValueExpression createValueExpression(FacesContext context, String expr, Class value) {
		return context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), expr, value);
	}

	private static PropertyDescriptor doGetPropertyDescriptor(final Class<?> type, final String propertyName) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : propertyDescriptors) {
				if (pd.getName().equals(propertyName)) {
					return pd;
				}
			}
			return null;
		} catch (Exception ex) {
			throw new ComponentRenderException("Unable to get property " + propertyName + " for class " + type, ex);
		}
	}
	
	public static String getLabelText(Class<?> type,String propertyName) {
		String messageBundleKey = type.getName() + "." + propertyName;
		InputStream inputStream = TagUtils.class.getClassLoader().getResourceAsStream("messages_en.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String message = (String) properties.get(messageBundleKey);
			if(message != null) {
				return message;
			}
		} catch (IOException e) {
			return propertyName;
		}
		return propertyName;
	}

	public static String currentDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		return dateFormat.format(new Date());
	}
	
	public static String getAnnotedADDataListType(Class<?> type,String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		
		if(!isADDataList(type, propertyName)) {
			throw new ComponentRenderException("Component is not a ADDataList");
		}
		
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(ADDataList.class)) {
			ADDataList annotation = field.getAnnotation(ADDataList.class);
			return annotation.type();
		}
		return null;
	}
	
	public static String getADAutocompleteListType(Class<?> type,String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		
		if(!isADAutocompleteField(type, propertyName)) {
			throw new ComponentRenderException("Component is not a ADDataList");
		}
		
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(ADAutocomplete.class)) {
			ADAutocomplete annotation = field.getAnnotation(ADAutocomplete.class);
			return annotation.type();
		}
		return null;
	}
	
	public static List<SelectItem> getADDataList(String listType) {
		if (listType == null || listType.isEmpty()) {
			throw new ComponentRenderException("Attribute listType cannot be empty");
		}
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		DataSource adListDataSource = new ADListDataSource(listType);
		List data = adListDataSource.getData();
		if (data != null) { // TODO
			for (Object o : data) {
				ADListItem adListItem = (ADListItem) o;
				selectItems.add(new SelectItem(adListItem.getValue(), adListItem.getLabel()));
			}
		}
		return selectItems;
	}

	public static List<SelectItem> getDataList(Class<?> type, String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class must not be null");
		}
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		if (isEnumDataList(type, propertyName)) {
			EnumDataSource enumDataSource = new EnumDataSource(type);
			List list = enumDataSource.getData();
			if (list != null) {
				for (Object o : list) {
					selectItems.add(new SelectItem(o.toString(), o.toString()));
				}
			}
		} else if (isADDataList(type, propertyName)) {
			Field field = getField(type, propertyName);
			ADDataList annotation = field.getAnnotation(ADDataList.class);
			String listType = annotation.type();
			if (!StringUtils.hasLength(listType)) {
				throw new DataSourceException("ADDataList.type cannot be null.");
			}
			DataSource adListDataSource = new ADListDataSource(listType);
			List data = adListDataSource.getData();
			if (data != null) { // TODO
				for (Object o : data) {
					ADListItem adListItem = (ADListItem) o;
					selectItems.add(new SelectItem(adListItem.getValue(), adListItem.getLabel()));
				}
			}
		}
		return selectItems;
	}

	public static boolean isDataList(Class<?> type, String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(ListItem.class)) {
			return true;
		}
		return false;
	}

	public static boolean isADDataList(Class<?> type, String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(ADDataList.class)) {
			return true;
		}
		return false;
	}
	
	public static boolean isADAutocompleteField(Class<?> type, String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(ADAutocomplete.class)) {
			return true;
		}
		return false;
	}

	public static boolean isEnumDataList(Class<?> type, String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(EnumDataList.class)) {
			return true;
		}
		return false;
	}

	public static boolean isRequired(Class<?> type, String propertyName) {
		if (propertyName == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(Required.class)) {
			return true;
		}
		return false;
	}

	public static boolean isText(Class<?> type, String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null");
		}
		
		if(isADDataList(type, propertyName) || isADAutocompleteField(type, propertyName)) {
			return false;
		}
		
		PropertyDescriptor pd = doGetPropertyDescriptor(type, propertyName);
		if (pd == null) {
			throw new ComponentRenderException("PropertyName not found");
		}
		Class<?> propertyType = pd.getPropertyType();

		if (propertyType == String.class
				|| propertyType == Integer.class
				|| propertyType == BigDecimal.class
				|| propertyType == BigInteger.class
				|| propertyType == Character.class
				|| propertyType == Long.class
				|| propertyType == Short.class
				|| propertyType == Byte.class
				|| propertyType == Float.class
				|| propertyType == Double.class
				|| (propertyType.isPrimitive() && !propertyType.getName().equals("boolean") && !propertyType.getName()
						.equals("enum"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isTextArea(Class<?> type, String propertyName) {
		boolean isText = isText(type, propertyName);
		if (!isText) {
			return false;
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(TextArea.class)) {
			return true;
		}
		return false;
	}

	public static boolean isRichTextArea(Class<?> type, String propertyName) {
		if (!isTextArea(type, propertyName)) {
			return false;
		}
		Field field = getField(type, propertyName);
		if (field == null) {
			throw new ComponentRenderException("Field must not be null");
		}
		if (field.isAnnotationPresent(TextArea.class)) {
			TextArea annotation = field.getAnnotation(TextArea.class);
			return annotation.richText;
		}
		return false;
	}

	public static boolean isEnum(final Class<?> type, final String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null, type=%s, propertyName=%s",
					type, propertyName);
		}
		PropertyDescriptor pd = doGetPropertyDescriptor(type, propertyName);
		if (pd == null) {
			throw new ComponentRenderException("The Property was not found!, type=%s, propertyName=%s", type, propertyName);
		}

		Class<?> propertyType = pd.getPropertyType();
		if (propertyType == Enum.class) {
			return true;
		} else if (propertyType.isEnum()) {
			return true;
		}
		return false;
	}

	public static boolean isBoolean(final Class<?> type, final String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null, type=%s, propertyName=%s",
					type, propertyName);
		}
		PropertyDescriptor pd = doGetPropertyDescriptor(type, propertyName);
		if (pd == null) {
			throw new ComponentRenderException("The Property was not found!, type=%s, propertyName=%s", type, propertyName);
		}
		Class<?> propertyType = pd.getPropertyType();
		if (propertyType == Boolean.class) {
			return true;
		} else if (propertyType.isPrimitive() && "boolean".equals(propertyType.getName())) {
			return true;
		}
		return false;
	}

	public static boolean isNumeric(final Class<?> type, final String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null, type=%s, propertyName=%s",
					type, propertyName);
		}
		PropertyDescriptor pd = doGetPropertyDescriptor(type, propertyName);
		if (pd == null) {
			throw new ComponentRenderException("The Property was not found!, type=%s, propertyName=%s", type, propertyName);
		}
		Class<?> propertyType = pd.getPropertyType();
		if (propertyType.isAssignableFrom(Number.class)) {
			return true;
		} else if (propertyType.isPrimitive() && !propertyType.getName().equals("boolean")
				&& !propertyType.getName().equals("enum")) {
			return true;
		}
		return false;
	}

	public static PropertyDescriptor getPropertyDescriptor(final Class<?> type, final String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null, type=%s, propertyName=%s",
					type, propertyName);
		}

		if (!propertyName.contains(".")) {
			return doGetPropertyDescriptor(type, propertyName);
		} else {
			String[] propertyNames = propertyName.split("[.]");
			Class<?> clazz = type;
			PropertyDescriptor propertyDescriptor = null;
			for (String pName : propertyNames) {
				propertyDescriptor = doGetPropertyDescriptor(clazz, pName);
				if (propertyDescriptor == null) {
					return null;
				}
				clazz = propertyDescriptor.getPropertyType();
			}
			return propertyDescriptor;
		}
	}

	public static Field getField(final Class<?> type, final String fieldName) {
		if (!fieldName.contains(".")) {
			return doFindFieldInHeirarchy(type, fieldName);
		} else {
			String[] fieldNames = fieldName.split("[.]");
			Class<?> clazz = type;
			Field field = null;
			for (String fName : fieldNames) {
				field = doFindFieldInHeirarchy(clazz, fName);
				if (field == null) {
					return null;
				}
				clazz = field.getType();
			}
			return field;
		}
	}

	private static Field doFindFieldInHeirarchy(Class<?> clazz, String propertyName) {
		Field field = doGetField(clazz, propertyName);

		Class<?> sclazz = clazz.getSuperclass();
		if (field == null) {
			while (true) {
				if (sclazz != null) {
					field = doGetField(sclazz, propertyName);
					sclazz = sclazz.getSuperclass();
				}
				if (field != null) {
					break;
				}
				if (sclazz == null) {
					break;
				}
			}
		}
		return field;
	}

	public static boolean isDate(Class<?> type, String propertyName) {
		if (type == null || propertyName == null) {
			throw new ComponentRenderException("Class type and propertyName must not be null, type=%s, propertyName=%s",
					type, propertyName);
		}
		PropertyDescriptor pd = getPropertyDescriptor(type, propertyName);
		if (pd == null) {
			throw new ComponentRenderException("The Property was not found!, type=%s, propertyName=%s", type, propertyName);
		}
		Class<?> propertyType = pd.getPropertyType();
		if (Date.class.isAssignableFrom(propertyType)) {
			return true;
		}
		return false;
	}

	public static boolean isUrl(Object value) {
		boolean rv = false;
		if (value != null && value instanceof String) {
			String lcValue = ((String) value).toLowerCase();
			if ((lcValue.indexOf(".com") > 0) || (lcValue.indexOf(".org") > 0) || (lcValue.indexOf(".edu") > 0)
					|| (lcValue.indexOf(".biz") > 0) || (lcValue.indexOf(".info") > 0) || (lcValue.indexOf(".mobi") > 0)
					|| (lcValue.indexOf(".us") > 0) || (lcValue.indexOf(".ca") > 0) || (lcValue.indexOf(".net") > 0)) {
				rv = true;
			}
		}
		return rv;
	}

	private static Field doGetField(Class<?> clazz, String fieldName) {
		Field field = null;
		try {
			field = clazz.getField(fieldName);
		} catch (SecurityException se) {
			field = null;
		} catch (NoSuchFieldException nsfe) {
			field = null;
		}
		if (field == null) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				if (f.getName().equals(fieldName)) {
					field = f;
				}
			}
		}
		if (field != null) {
			field.setAccessible(true);
		}
		return field;
	}

}
