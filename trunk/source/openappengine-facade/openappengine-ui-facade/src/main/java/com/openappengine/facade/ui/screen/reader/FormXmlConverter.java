/**
 * 
 */
package com.openappengine.facade.ui.screen.reader;

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
public class FormXmlConverter implements Converter {
	
	private final Converter defaultConverter;
	
	private final ReflectionProvider reflectionProvider;
	
	public FormXmlConverter(Converter converter,ReflectionProvider reflectionProvider) {
		this.defaultConverter = converter;
		this.reflectionProvider = reflectionProvider;
	}

	@Override
	public boolean canConvert(Class clazz) {
		return Form.class.isAssignableFrom(clazz);
	}

	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		defaultConverter.marshal(object, writer, context);
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Object currentObject = context.currentObject();
		return currentObject;
	}

}
