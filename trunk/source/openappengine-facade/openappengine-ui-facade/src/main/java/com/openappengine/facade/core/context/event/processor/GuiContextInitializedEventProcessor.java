package com.openappengine.facade.core.context.event.processor;

import java.io.StringReader;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import com.openappengine.facade.core.Resolver;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;
import com.openappengine.facade.core.component.widget.Widget;
import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;

import freemarker.ext.dom.NodeModel;

public class GuiContextInitializedEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		logger.info("Processing Context Initialized Event.");
		
		//Add Root to the Model Map.
		GuiRootComponent root = context.getUIRoot();
		context.getExternalContext().addModelMapAttribute("uiRoot", root);
		
		//testXmlProcessing(context);
		
		//Resolve Components Value Refs
		resolveGuiComponentValueRef(context.getUIRoot().getPageContent(), context);
	}

	/**
	 * <!--
		XML Processing By Freemarker
	 	<#foreach recipient in doc.recipients.person>
	 		To: ${recipient.name} <br />
			    ${recipient.address} <br />
	        Dear ${recipient.name}, <br/>
	   	</#foreach>
	   	-->
	 * Test XML Processing by Freemarker.
	 * @param context
	 */
	private void testXmlProcessing(GuiApplicationContext context) {
		String xml = "<recipients><person><name>John Smith</name><address>3033 Long Drive, Houston, TX</address></person><person><name>Janet Mason</name><address>11c Poplar Drive, Knoxville, TN</address></person></recipients>";
		try {
			NodeModel nodeModel = NodeModel.parse(new InputSource(new StringReader(xml)));
			context.getExternalContext().addModelMapAttribute("doc", nodeModel);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resolveGuiComponentValueRef(GuiComponent root, GuiApplicationContext context) {
		resolveValueRef(context, root);
		if (root.hasChildren()) {
			for (GuiComponent guiComponent : root.getChildComponents()) {
				resolveGuiComponentValueRef(guiComponent, context);
			}
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void resolveValueRef(GuiApplicationContext context, GuiComponent guiComponent) {
		if (guiComponent instanceof ValueRefAware<?>) {
			doResolveValueRef(context, guiComponent);
		}
		
		//Form Widget. If component is a Form Widget add the model attribute.
		mergeFormWidgetModel(context, guiComponent);
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void mergeFormWidgetModel(GuiApplicationContext context,
			GuiComponent guiComponent) {
		if(guiComponent instanceof Widget) {
			Object formBackingObject = ((Widget) guiComponent).formBackingObject();
			context.getExternalContext().addModelMapAttribute(guiComponent.getId(), formBackingObject);
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void doResolveValueRef(GuiApplicationContext context, GuiComponent guiComponent) {
		//TODO - Not used the isValueSet method.
		String valueRef = ((ValueRefAware) guiComponent).getValueRef();
		Resolver variableResolver = context.getVariableResolver();
		Object value = variableResolver.resolve(valueRef);
		((ValueRefAware) guiComponent).setValue(value);
	}
}