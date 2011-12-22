/**
 * 
 */
package com.openappengine.facade.ui.screen.reader;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.ui.widgets.Widget;
import com.openappengine.facade.ui.widgets.forms.Form;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author hrishikesh.joshi
 * @Dec 22, 2011
 */
public class WidgetTypeConverter implements Converter {
	
	private final Converter defaultConverter;
	
	private final ReflectionProvider reflectionProvider;
	
	public WidgetTypeConverter(Converter converter,ReflectionProvider reflectionProvider) {
		this.defaultConverter = converter;
		this.reflectionProvider = reflectionProvider;
	}

	@Override
	public boolean canConvert(Class cls) {
		return Widget.class.isAssignableFrom(cls);
	}

	@Override
	public void marshal(Object object, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
		defaultConverter.marshal(object, hierarchicalStreamWriter, marshallingContext);
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
		String type = hierarchicalStreamReader.getAttribute("type");
		if(StringUtils.equals(type, "form")) {
			Class<?> clazz = Form.class;
			Object result = reflectionProvider.newInstance(clazz);
	        return unmarshallingContext.convertAnother(result, clazz, defaultConverter);
		}
		//TODO - Add a lookup here.
		return null;
	}

}
