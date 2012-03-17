/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.gui.engine.core.widget.binder.DefaultHttpServletWidgetBinder;
import com.openappengine.gui.engine.core.widget.binder.HttpServletWidgetBinder;
import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContext;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public abstract class AbstractWidgetProcessor implements WidgetProcessor {
	
	protected WidgetProcessorContext widgetProcessorContext;
	
	protected static final Logger logger = Logger.getLogger(WidgetProcessor.class);

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		Assert.notNull(context, "WidgetProcessorContext cannot be null.");
		this.widgetProcessorContext = context;
	}

	@Override
	public Object processWidget() {
		logger.debug("Processing Widget..");
		String widgetId = widgetProcessorContext.getWidgetId();
		
		WidgetTemplateNode widgetTemplateNode = widgetProcessorContext.getELContext().getVariable(widgetId,WidgetTemplateNode.class);
		Assert.notNull(widgetTemplateNode, "WidgetTemplateNode not found for Widget ID " + widgetId);
		
		HttpServletWidgetBinder binder = new DefaultHttpServletWidgetBinder(widgetTemplateNode);
		HttpServletRequest request = (HttpServletRequest) widgetProcessorContext.getExternalContext().getRequest();
		binder.bind(request);
		widgetTemplateNode.setBindingResult(binder.getBindingResult());
		
		if(binder.hasErrors()) {
			BindingResult bindingResult = binder.getBindingResult();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			if(fieldErrors != null) {
				for (FieldError fieldError : fieldErrors) {
					widgetProcessorContext.getMessageContext().addErrorMessage(fieldError.getDefaultMessage());
				}
			}
			
			return null;
		}
		
		widgetProcessorContext.getELContext().registerELContextVariable(widgetId, widgetTemplateNode.getValueEntity());
		
		//Call Service/Action
		String actionParam = request.getParameter("action");
		if(StringUtils.isNotEmpty(actionParam)) {
			//Process Action.
			Element actionEle = widgetTemplateNode.getActionMap().get(actionParam);
			
			List<Element> childActionElements = DomUtils.getChildElements(actionEle);
			if(childActionElements != null) {
				for (Element childActionElement : childActionElements) {
					if("service-call".equals(childActionElement.getNodeName())) {
						processAction(childActionElement);
					}
					//Transition to other screen.
				}
			}
		}
		
		//Display the Success Message.
		widgetProcessorContext.getMessageContext().addSuccessMessage("Action Completed.");
		
		//Register WidgetTemplateNode with Context.
		widgetProcessorContext.getELContext().registerELContextVariable(widgetId, widgetTemplateNode);
		
		return null;
	}
	
	private void processAction(Element element) {

		String serviceName = UtilXml.readElementAttribute(element, "service");
		if(StringUtils.isEmpty(serviceName)) {
			widgetProcessorContext.getMessageContext().addErrorMessage("Attribute 'service' is mandatory for a service call. Cannot execute service :" + serviceName);
			return;
		}
		
		List<Element> parameterEles = DomUtils.getChildElementsByTagName(element, "parameter");
		Map<String,Object> params = new HashMap<String, Object>();
		if(parameterEles != null) {
			for (Element parameterEle : parameterEles) {
				String name = UtilXml.readElementAttribute(parameterEle, "name");
				if(StringUtils.isEmpty(name)) {
					widgetProcessorContext.getMessageContext().addErrorMessage("Attribute 'name' is mandatory for a service call-parameter." +
							" Cannot execute service :" + serviceName);
					return;		
				}
				
				String value = UtilXml.readElementAttribute(parameterEle, "value");
				if(StringUtils.startsWith(value, "#{") && StringUtils.endsWith(value, "}")) {
					String valueRef = StringUtils.substringBetween(value, "#{", "}");
					if(StringUtils.isNotBlank(valueRef)) {
						Object evaluatedValue = widgetProcessorContext.getELContext().getVariable(valueRef);
						params.put(name, evaluatedValue);
					}
				} else {
					params.put(name, value);
				}
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
						widgetProcessorContext.getELContext().registerELContextVariable(key, value);
					}
				}
			}
		} catch (ServiceException e) {
			widgetProcessorContext.getMessageContext().addErrorMessage("Service :" + serviceName + " returned error/s.");
		}
	
	}
}