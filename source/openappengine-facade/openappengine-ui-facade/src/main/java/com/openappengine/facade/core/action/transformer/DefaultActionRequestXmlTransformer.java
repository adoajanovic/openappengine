/**
 * 
 */
package com.openappengine.facade.core.action.transformer;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.annotation.AnnotationUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.DefaultActionRequestXml;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.executor.annotations.Action;
import com.openappengine.facade.core.xml.transformer.StringTypeConverter;
import com.openappengine.utility.ObjectConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public class DefaultActionRequestXmlTransformer implements ActionRequestXmlTransformer {
	
	private final Map<Class<?>, StringTypeConverter> customTypeConverters = new ConcurrentHashMap<Class<?>, StringTypeConverter>();
	
	static {
		//TODO Register DefaultType Converters.
	}
	
	@Override
	public ActionRequestXml transform(AbstractExecutableComponent executableComponent) {
		if(executableComponent == null) {
			throw new IllegalStateException("No Executable Action Found !! Cannot call the ActionHandler.");
		}
		
		Document xmlDocument = UtilXml.makeEmptyXmlDocument("action-request");
		
		Action action = AnnotationUtils.findAnnotation(executableComponent.getClass(), Action.class);
		String actionName = action.actionName();
		xmlDocument.createAttribute("action-name").setValue(actionName);
		
		BeanWrapper executableBeanWrapper = new BeanWrapperImpl(executableComponent);
		Class<?> wrappedClazz = executableComponent.getClass();
		
		Field[] fields = wrappedClazz.getDeclaredFields();
		
		for (Field field : fields) {
			//TODO - Can be converted to an annotation for mapping to xml node.
			String fieldProperty = field.getName();
			if(executableBeanWrapper.isReadableProperty(fieldProperty)) {
				Element requestParamElement = xmlDocument.createElement("request-param");
				requestParamElement.setAttribute("name", fieldProperty);
				Object value = executableBeanWrapper.getPropertyValue(fieldProperty);
				String stringValue = "";
				if(customTypeConverters.containsKey(field.getClass())) {
					StringTypeConverter typeConverter = customTypeConverters.get(field.getClass());
					typeConverter.convert(value);
				} else {
					stringValue = ObjectConverter.convert(value, String.class);
				}
				requestParamElement.setNodeValue(stringValue);
			}
		}
		ActionRequestXml actionRequestXml = new DefaultActionRequestXml(xmlDocument); 
		return actionRequestXml;
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringTypeConverter converter) {
		if(forClass == null) {
			throw new IllegalArgumentException("Classname found null. Cannot register the CustomConverter");
		}
		
		if(converter == null) {
			throw new IllegalArgumentException("Cannot register the CustomConverter for class " + forClass.getName() + ". Converter found null.");
		}
		
		customTypeConverters.put(forClass, converter);
	}

}
