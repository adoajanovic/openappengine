/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor.factory;

import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.widget.context.HttpServletWidgetProcessorContextFactory;
import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContext;
import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContextFactory;
import com.openappengine.gui.engine.core.widget.processor.WidgetProcessor;
import com.openappengine.gui.engine.fsm.TransitionEventListener;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class WidgetProcessorFactory {
	
	private static Map<String,WidgetProcessor> widgetProcessorMap = new ConcurrentHashMap<String, WidgetProcessor>();
	
	protected static final Logger logger = Logger.getLogger(WidgetProcessorFactory.class);

	private final WidgetProcessorContextFactory widgetProcessorContextFactory = new HttpServletWidgetProcessorContextFactory(); 
	
	static {
		Set<Class<? extends WidgetProcessor>> processors = new WidgetProcessorFactoryInitializer().initializeWidgetProcessorFactory();
		if(processors != null) {
			for (Class<? extends WidgetProcessor> clazz : processors) {
				try {
					if(!Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers())) {
						WidgetProcessor widgetProcessor = clazz.newInstance();
						widgetProcessorMap.put(widgetProcessor.getProcessedWidgetType(), widgetProcessor);
					}
				} catch (Exception e) {
					logger.error("Cannot Initialize WidgetProcessorFactory.",e);
					throw new RuntimeException("Cannot Initialize WidgetProcessorFactory");
				}
			}
		}
	}

	public WidgetProcessor getWidgetProcessor(ExternalContext externalContext,ELContext elContext,TransitionEventListener transitionEventListener,MessageContext messageContext,String widgetType) {
		if(StringUtils.isEmpty(widgetType)) {
			throw new IllegalStateException("WidgetType Type Cannot be Empty.");
		}
		
		WidgetProcessor widgetProcessor = null;
			widgetProcessor = widgetProcessorMap.get(widgetType);
			
		if (widgetProcessor == null) {
			throw new IllegalStateException("No WidgetProcessor Configured for WidgetType : "+ widgetType);
		}
			
		WidgetProcessorContext widgetProcessorContext = widgetProcessorContextFactory
					.createWidgetProcessorContext(externalContext, elContext,
							transitionEventListener, messageContext);
			

		widgetProcessor.setWidgetProcessorContext(widgetProcessorContext);
		
		return widgetProcessor;
	}
	
}
