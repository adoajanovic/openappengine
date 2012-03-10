package com.openappengine.gui.engine.core.widget.binder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.openappengine.entity.api.RequiredFieldMissingException;
import com.openappengine.entity.api.ValueEntity;
import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.utility.ObjectConverter.ObjectConverterException;

/**
 * 
 * @author hrishi
 * since Mar 10, 2012
 */
public class DefaultHttpServletWidgetBinder implements HttpServletWidgetBinder {
	
	private WidgetTemplateNode widgetTemplateNode;
	
	private BindingResult bindingResult;
	
	/**
	 * @param widgetTemplateNode
	 */
	public DefaultHttpServletWidgetBinder(WidgetTemplateNode widgetTemplateNode) {
		if(widgetTemplateNode == null) {
			throw new IllegalArgumentException("WidgetTemplateNode cannot be null.");
		}
		this.widgetTemplateNode = widgetTemplateNode;
		
		bindingResult = new MapBindingResult(new HashMap(), widgetTemplateNode.getWidgetId());
	}

	@Override
	public void bind(HttpServletRequest request) {
		ValueEntity valueEntity = widgetTemplateNode.getValueEntity();
		Map<String, Object> fieldValues = valueEntity.getFieldValues();
		if(fieldValues != null) {
			Set<String> keySet = fieldValues.keySet();
			for (String key : keySet) {
				String value = (String) request.getParameter(key);
				
				if(valueEntity.isRequired(key)) {
					if(StringUtils.isEmpty(value)) {
						bindingResult.addError(new FieldError(widgetTemplateNode.getWidgetId(), key, key + "." + "required.missing"));
						continue;
					}
				}
				
				try {
					widgetTemplateNode.getValueEntity().put(key, value);
				} catch(ObjectConverterException e) {
					bindingResult.addError(new ObjectError(key, key + "." + "binding.error"));
				}
			}
		}
	}

	@Override
	public boolean hasErrors() {
		return bindingResult.hasErrors();
	}

	@Override
	public BindingResult getBindingResult() {
		return bindingResult;
	}

}
