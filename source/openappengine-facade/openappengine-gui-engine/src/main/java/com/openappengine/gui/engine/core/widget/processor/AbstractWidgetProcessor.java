/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.gui.engine.core.widget.binder.DefaultHttpServletWidgetBinder;
import com.openappengine.gui.engine.core.widget.binder.HttpServletWidgetBinder;
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
		String widgetId = widgetProcessorContext.getWidgetId();
		
		WidgetTemplateNode widgetTemplateNode = widgetProcessorContext.getELContext().getVariable(widgetId,WidgetTemplateNode.class);
		Assert.notNull(widgetTemplateNode, "WidgetTemplateNode not found for Widget ID " + widgetId);
		
		HttpServletWidgetBinder binder = new DefaultHttpServletWidgetBinder(widgetTemplateNode);
		binder.bind((HttpServletRequest) widgetProcessorContext.getExternalContext().getRequest());
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
		
		widgetProcessorContext.getELContext().registerELContextVariable(widgetId, widgetTemplateNode);
		
		return null;
	}
}