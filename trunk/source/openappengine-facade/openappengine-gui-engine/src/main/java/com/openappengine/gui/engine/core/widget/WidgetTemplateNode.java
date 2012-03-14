/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.w3c.dom.Document;

import com.openappengine.entity.api.ValueEntity;

/**
 * @author hrishi
 * since Mar 3, 2012
 */
public class WidgetTemplateNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String widgetId;
	
	private Document widgetTemplateXml;
	
	private ValueEntity valueEntity;
	
	private BindingResult bindingResult;

	/**
	 * @param widgetId
	 * @param widgetTemplateXml
	 * @param widgetDataXml
	 */
	public WidgetTemplateNode(String widgetId,Document widgetTemplateXml,ValueEntity valueEntity) {
		super();
		this.widgetId = widgetId;
		this.widgetTemplateXml = widgetTemplateXml;
		this.setValueEntity(valueEntity);
		this.bindingResult = new MapBindingResult(new HashMap(), widgetId);
	}

	/**
	 * @return the widgetId
	 */
	public String getWidgetId() {
		return widgetId;
	}

	/**
	 * @param widgetId the widgetId to set
	 */
	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	/**
	 * @return the widgetTemplateXml
	 */
	public Document getWidgetTemplateXml() {
		return widgetTemplateXml;
	}

	/**
	 * @param widgetTemplateXml the widgetTemplateXml to set
	 */
	public void setWidgetTemplateXml(Document widgetTemplateXml) {
		this.widgetTemplateXml = widgetTemplateXml;
	}

	
	public Map<String, Object> getFieldValues() {
		if(valueEntity != null) {
			//valueEntity.put("username", "hrishi");
			return valueEntity.getFieldValues();
		}
		
		return new HashMap<String, Object>();
	}
	
	/**
	 * @return the widgetDataXml
	 */
	public Document getWidgetDataXml() {
		if(valueEntity != null) {
			Document xml = valueEntity.toXml();
			return xml;
		}
		return null;
	}
	
	public Object getValue(String fieldName) {
		if(valueEntity != null) {
			return valueEntity.get(fieldName);
		}
		
		return null;
	}
	
	public FieldError getFieldError(String field) {
		if(bindingResult == null) {
			return null;
		}
		return bindingResult.getFieldError(field);
	}
	
	public List<FieldError> getAllFieldErrors() {
		if(bindingResult == null) {
			return null;
		}
		return bindingResult.getFieldErrors();
	}

	public ValueEntity getValueEntity() {
		return valueEntity;
	}

	protected void setValueEntity(ValueEntity valueEntity) {
		this.valueEntity = valueEntity;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

}
