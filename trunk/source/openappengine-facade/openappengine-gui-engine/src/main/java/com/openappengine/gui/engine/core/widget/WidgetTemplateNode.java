/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.io.Serializable;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Mar 3, 2012
 */
public class WidgetTemplateNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String widgetId;
	
	private Document widgetTemplateXml;
	
	private Document widgetDataXml;

	/**
	 * @param widgetId
	 * @param widgetTemplateXml
	 * @param widgetDataXml
	 */
	public WidgetTemplateNode(String widgetId, Document widgetTemplateXml,
			Document widgetDataXml) {
		super();
		this.widgetId = widgetId;
		this.widgetTemplateXml = widgetTemplateXml;
		this.widgetDataXml = widgetDataXml;
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

	/**
	 * @return the widgetDataXml
	 */
	public Document getWidgetDataXml() {
		return widgetDataXml;
	}

	/**
	 * @param widgetDataXml the widgetDataXml to set
	 */
	public void setWidgetDataXml(Document widgetDataXml) {
		this.widgetDataXml = widgetDataXml;
	}

}
