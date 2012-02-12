/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.springframework.validation.BindingResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContext;

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
		Document previousBindedInstance = (Document) widgetProcessorContext
						.getELContext().getVariable(widgetProcessorContext.getWidgetId());
		
		Map<String, Object> requestParameters = widgetProcessorContext.getExternalContext().getRequestParameters();
		
		BindingResult bindingResult = bindWidgetXmlDocument(previousBindedInstance, requestParameters);
		if(bindingResult != null) {
			//Return
			widgetProcessorContext.getExternalContext().getModelMap().addAttribute(widgetProcessorContext.getWidgetId(), previousBindedInstance);
			return null;
		}
		//Bind Successful Instance.
		widgetProcessorContext.getExternalContext().getModelMap().addAttribute(widgetProcessorContext.getWidgetId(), previousBindedInstance);
		return null;
	}

	/**
	 * @param previousBindedInstance
	 * @param requestParameters
	 */
	private BindingResult bindWidgetXmlDocument(Document previousBindedInstance,
			Map<String, Object> requestParameters) {
		List<Element> childElements = DomUtils.getChildElements(previousBindedInstance.getDocumentElement());
		if(childElements != null) {
			for (Element element : childElements) {
				String attrName = element.getAttribute("name");
				String attrType = element.getAttribute("type");
				
				String value = (String) requestParameters.get(attrName);
				//TODO - Handle Type Conversion.
				//Check By Type if the value is valid. if yes, set the text value.
				element.setTextContent(value);
			}
		}
		return null;
	}

	private void doBinding() {
		
	}
}