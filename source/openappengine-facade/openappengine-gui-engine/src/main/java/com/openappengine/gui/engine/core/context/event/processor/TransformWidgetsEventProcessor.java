/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import com.openappengine.entity.EntityFacade;
import com.openappengine.entity.context.EntityFacadeContext;
import com.openappengine.entity.definition.Entity;
import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.ui.container.WidgetsComponent;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiApplicationContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.transformer.WidgetTransformer;
import com.openappengine.gui.engine.core.widget.Widget;

/**
 * @author hrishikesh.joshi
 * @since  Feb 21, 2012
 *
 */
public class TransformWidgetsEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event,GuiApplicationContext t) {
		List<WidgetsComponent> widgets = t.getUIRoot().getPageContent().getWidgets();
		for (WidgetsComponent widgetComponent : widgets) {
			List<GuiComponent> childWidgets = widgetComponent.getChildComponents();
			if (childWidgets != null) {
				for (GuiComponent guiComponent : childWidgets) {
					Widget widget = (Widget) guiComponent;
					doTransformWidget(t, widget);
				}
			}
		}
	}
	
	/**
	 * @param t
	 * @param widget
	 */
	private void doTransformWidget(GuiApplicationContext t, Widget widget) {
		String valueRef = widget.getValueRef();
		WidgetTransformer widgetTransformer = new WidgetTransformer(widget);
		Document doc = null;
		
		if(StringUtils.isNotEmpty(valueRef)) {
			//If this widget has a value-reference in the EL Context. 
			//Get the XML from the the EL Context.  
			doc = t.getELContext().getVariable(valueRef,Document.class);
		} else {
			//If no value-reference has been provided, get the Entity Definintion XML
			//from the EntityFacade.
			EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
			Entity entityDefinition = entityFacade.findEntityDefinition(widget.getEntityName());
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
	}

	/**
	 * @param t
	 * @param widget
	 * @param transformedDocumentXml
	 */
	private void registerWidgetWithModelMap(GuiApplicationContext t,
			Widget widget, Document transformedDocumentXml) {
		widget.setValue(transformedDocumentXml);
		t.getExternalContext().addModelMapAttribute(widget.getId(), transformedDocumentXml);
	}

}
