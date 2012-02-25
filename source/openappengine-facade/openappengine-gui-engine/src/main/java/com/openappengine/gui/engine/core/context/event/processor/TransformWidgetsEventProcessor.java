/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.entity.definition.Entity;
import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.ui.container.WidgetContainer;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.transformer.WidgetTransformer;
import com.openappengine.gui.engine.core.widget.Widget;

/**
 * @author hrishikesh.joshi
 * @since  Feb 21, 2012
 *
 */
public class TransformWidgetsEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event,GuiEngineContext t) {
		List<Widget> screenWidgets = t.getScreenWidgets();
		if (screenWidgets != null) {
			for (Widget widget : screenWidgets) {
				Document document = doTransformWidget(t,widget);
				widget.setValue(document);
			}
		}
	}
	
	/**
	 * @param t
	 * @param widget
	 */
	private Document doTransformWidget(GuiEngineContext t, Widget widget) {
		String valueRef = widget.getValueRef();
		WidgetTransformer widgetTransformer = new WidgetTransformer(widget);
		Document doc = null;
		
		if(StringUtils.isNotEmpty(valueRef)) {
			//If this widget has a value-reference in the EL Context. 
			//Get the XML from the the EL Context.  
			doc = t.getELContext().getVariable(valueRef,Document.class);
		} else {
			//If no value-reference has been provided, get the Entity Definintion XML
			//from the EntityEngineFacade.
			EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
			Entity entityDefinition = entityEngineFacade.findEntityDefinition(widget.getEntityName());
			if (entityDefinition == null) {
				throw new IllegalStateException("Entity " + widget.getEntityName() + " not found for Widget : [id:"
						+ widget.getId() + "].");
			}
			doc = entityDefinition.getDocument();
		}
		
		//Transform Widget XML
		Document transformedDocumentXml = widgetTransformer.transform(doc);
		//Add Model Mapping For this Widget.
		registerWidgetWithModelMap(t, widget, transformedDocumentXml);
		
		return transformedDocumentXml;
	}

	/**
	 * @param t
	 * @param widget
	 * @param transformedDocumentXml
	 */
	private void registerWidgetWithModelMap(GuiEngineContext t,
			Widget widget, Document transformedDocumentXml) {
		t.getExternalContext().addModelMapAttribute(widget.getId(), transformedDocumentXml);
	}

}
