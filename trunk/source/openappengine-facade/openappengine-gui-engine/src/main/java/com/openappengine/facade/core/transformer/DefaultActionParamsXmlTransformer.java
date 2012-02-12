/**
 * 
 */
package com.openappengine.facade.core.transformer;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.facade.core.action.xml.ActionParamsXml;
import com.openappengine.facade.core.action.xml.DefaultActionParamsXml;
import com.openappengine.facade.core.action.xml.EntityActionParamsXml;
import com.openappengine.facade.core.annotations.ActionParam;
import com.openappengine.facade.core.component.executable.AbstractEntityActionTag;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.executor.annotations.Action;
import com.openappengine.facade.core.transformer.ActionParamsXmlTransformer;
import com.openappengine.facade.core.xml.transformer.StringConverter;
import com.openappengine.utility.ObjectConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public class DefaultActionParamsXmlTransformer implements ActionParamsXmlTransformer {
	
	private final Map<Class<?>, StringConverter> customTypeConverters = new ConcurrentHashMap<Class<?>, StringConverter>();
	
	static {
		//TODO Register DefaultType Converters.
	}
	
	@Override
	public ActionParamsXml transform(AbstractExecutableComponent executableComponent) {
		if(executableComponent == null) {
			throw new IllegalStateException("No Executable Action Found !! Cannot call the ActionHandler.");
		}
		
		final Document xmlDocument = UtilXml.makeEmptyXmlDocument("action-params");
		
		Action action = AnnotationUtils.findAnnotation(executableComponent.getClass(), Action.class);
		String actionName = action.actionName();
		final Element documentElement = xmlDocument.getDocumentElement();
		documentElement.setAttribute("action-name", actionName);
		
		final BeanWrapper executableBeanWrapper = new BeanWrapperImpl(executableComponent);
		Class<?> wrappedClazz = executableComponent.getClass();
		
		Field[] fields = wrappedClazz.getDeclaredFields();
		
		ReflectionUtils.doWithFields(wrappedClazz, new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException,IllegalAccessException {
				//TODO - Can be converted to an annotation for mapping to xml node.
				if(!field.isAnnotationPresent(ActionParam.class)) {
					return;
				}
				
				ActionParam actionParam = field.getAnnotation(ActionParam.class);
				
				String fieldProperty = field.getName();
				if(executableBeanWrapper.isReadableProperty(fieldProperty)) {
					Object value = executableBeanWrapper.getPropertyValue(fieldProperty);
					String stringValue = "";
					if(customTypeConverters.containsKey(field.getClass())) {
						StringConverter typeConverter = customTypeConverters.get(field.getClass());
						stringValue = typeConverter.convert(value);
					} else {
						//TODO - Handle Unsupported 'from' types.
						stringValue = ObjectConverter.convert(value, String.class);
					}
					Element element = xmlDocument.createElement("action-param");
					element.setAttribute("name", actionParam.name());
					element.setTextContent(stringValue);
					documentElement.appendChild(element);
				}
			}
		});
		
		/*for (Field field : fields) {
			//TODO - Can be converted to an annotation for mapping to xml node.
			String fieldProperty = field.getName();
			if(executableBeanWrapper.isReadableProperty(fieldProperty)) {
				Object value = executableBeanWrapper.getPropertyValue(fieldProperty);
				String stringValue = "";
				if(customTypeConverters.containsKey(field.getClass())) {
					StringConverter typeConverter = customTypeConverters.get(field.getClass());
					stringValue = typeConverter.convert(value);
				} else {
					stringValue = ObjectConverter.convert(value, String.class);
				}
				Element element = xmlDocument.createElement("action-param");
				element.setAttribute("name", fieldProperty);
				element.setTextContent(stringValue);
				documentElement.appendChild(element);
			}
		}*/
		
		//TODO - Parameterize the ActionParamsXml Creation. 
		ActionParamsXml actionParamsXml = null;
		
		if(executableComponent instanceof AbstractEntityActionTag) {
			String entityName = ((AbstractEntityActionTag) executableComponent).getEntityName();
			actionParamsXml = new EntityActionParamsXml(entityName,xmlDocument);
		} else {
			actionParamsXml = new DefaultActionParamsXml(xmlDocument);
		}
		
		return actionParamsXml;
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
		if(forClass == null) {
			throw new IllegalArgumentException("Classname found null. Cannot register the CustomConverter");
		}
		
		if(converter == null) {
			throw new IllegalArgumentException("Cannot register the CustomConverter for class " + forClass.getName() + ". Converter found null.");
		}
		
		customTypeConverters.put(forClass, converter);
	}

}
