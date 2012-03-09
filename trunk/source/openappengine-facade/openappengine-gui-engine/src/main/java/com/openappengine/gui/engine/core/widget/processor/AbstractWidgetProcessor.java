/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.springframework.validation.BindingResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContext;
import com.openappengine.utility.UtilXml;
import com.openappengine.utility.xml.XmlVisitor;
import com.openappengine.utility.xml.XmlVisitor.XmlVisitorCallback;

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
		
		Object widgetTemplateNode = widgetProcessorContext.getELContext().getVariable(widgetId);
		Document bindedXml = ((WidgetTemplateNode) widgetTemplateNode).getWidgetDataXml();
		
		Map<String, Object> requestParameters = widgetProcessorContext.getExternalContext().getRequestParameters();
		
		BindingResult bindingResult = bindWidgetXmlDocument(bindedXml, requestParameters);
		if(bindingResult != null) {
			//Return
			widgetProcessorContext.getExternalContext().getModelMap().addAttribute(widgetId, bindedXml);
			return null;
		}
		//Bind Successful Instance.
		widgetProcessorContext.getExternalContext().getModelMap().addAttribute(widgetId, bindedXml);
		return null;
	}

	/**
	 * @param bindedXml
	 * @param requestParameters
	 */
	private BindingResult bindWidgetXmlDocument(final Document bindedXml,
			final Map<String, Object> requestParameters) {
		Set<String> keys = requestParameters.keySet();
		for (String key : keys) {
			String value = (String) requestParameters.get(key);
			if(key.startsWith("/")) {
				Node evalNode = UtilXml.evaluateXPathNode(bindedXml, key);
				if(evalNode != null) {
					String type = UtilXml.readElementAttribute((Element) evalNode, "type");
					//TODO - Check for type and binding issues.
					
					evalNode.setTextContent("");
					evalNode.appendChild(bindedXml.createTextNode(value));
				}
			}
		}
		
		UtilXml.writeXmlDocument(bindedXml);
		return null;
	}
}