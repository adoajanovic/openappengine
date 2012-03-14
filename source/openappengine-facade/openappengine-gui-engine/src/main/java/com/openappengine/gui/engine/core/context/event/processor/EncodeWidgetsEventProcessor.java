/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.api.ValueEntity;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.gui.engine.core.widget.WidgetTemplateProcessor;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Feb 21, 2012
 *
 */
public class EncodeWidgetsEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event,GuiEngineContext t) {
		Document screenXmlDocument = t.getScreenXmlDocument();
		Element pageContentEle = DomUtils.getChildElementByTagName(screenXmlDocument.getDocumentElement(), "page-content");
		
		List<Element> widgetElementList = DomUtils.getChildElementsByTagName(pageContentEle, "widget");
		if(widgetElementList != null) {
			for (Element widgetElement : widgetElementList) {
				
				Element preActionEle = DomUtils.getChildElementByTagName(widgetElement, "pre-action");
				if(preActionEle != null) {
					List<Element> serviceCallEles = DomUtils.getChildElementsByTagName(preActionEle,"service-call");
					if(serviceCallEles != null) {
						for (Element serviceCallEle : serviceCallEles) {
							//TODO Handle Each Action Ele and make calls to the Action Dispatcher.
							String serviceName = UtilXml.readElementAttribute(serviceCallEle, "service");
							if(StringUtils.isEmpty(serviceName)) {
								//
								t.getMessageContext().addErrorMessage("Attribute 'service' is mandatory for a service call. Cannot execute service :" + serviceName);
								continue;
							}
							
							List<Element> parameterEles = DomUtils.getChildElementsByTagName(serviceCallEle, "parameter");
							Map<String,Object> params = new HashMap<String, Object>();
							if(parameterEles != null) {
								for (Element parameterEle : parameterEles) {
									String name = UtilXml.readElementAttribute(parameterEle, "name");
									if(StringUtils.isEmpty(name)) {
										t.getMessageContext().addErrorMessage("Attribute 'name' is mandatory for a service call-parameter." +
												" Cannot execute service :" + serviceName);
										continue;		
									}
									
									String value = UtilXml.readElementAttribute(parameterEle, "value");
									params.put(name, value);
								}
							}
							
							//Call
							try {
								ServiceDispatcher defaultServiceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
								Map<String, Object> resultMap = defaultServiceDispatcher.runSync(serviceName, params);
								if(resultMap != null) {
									Set<Entry<String,Object>> entrySet = resultMap.entrySet();
									if(entrySet != null) {
										for (Entry<String, Object> entry : entrySet) {
											String key = entry.getKey();
											Object value = entry.getValue();
											t.getELContext().registerELContextVariable(key, value);
										}
									}
								}
							} catch (ServiceException e) {
								t.getMessageContext().addErrorMessage("Service :" + serviceName + " returned error/s.");
							}
						}
					}
				}
				
				String widgetId = widgetElement.getAttribute("id");
				String valueRef = widgetElement.getAttribute("value");
				
				Document widgetTemplateXml = encodeWidgetControls(widgetElement, t);
				ValueEntity valueEntity = t.getELContext().getVariable(valueRef,ValueEntity.class);;
				
				WidgetTemplateNode node = new WidgetTemplateNode(widgetId,widgetTemplateXml,valueEntity);
				t.addWidget(widgetId, node);
			}
		}
	}

	/**
	 * @param element
	 * @param context 
	 */
	protected Document encodeWidgetControls(Element element, GuiEngineContext context) {
		WidgetTemplateProcessor widgetTemplateProcessor = new WidgetTemplateProcessor();
		Document renderedWidgetXml = widgetTemplateProcessor.processWidgetTemplate(element, context);
		return renderedWidgetXml;
	}

}
