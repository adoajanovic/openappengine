/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.context.factory.support.ScreenDefinitionParserDelegate;
import com.openappengine.gui.engine.context.factory.support.parser.GuiElementDefinitionParser;
import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.Resolver;
import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.component.ui.message.ResourceBundleMessageContext;
import com.openappengine.gui.engine.core.el.DefaultJexlContext;
import com.openappengine.gui.engine.core.el.ExpressionEvaluator;
import com.openappengine.gui.engine.core.el.SimpleExpressionEvaluator;
import com.openappengine.gui.engine.core.resolve.ELContextVariableResolver;
import com.openappengine.gui.engine.core.variable.Variable;
import com.openappengine.gui.engine.core.widget.Widget;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public abstract class AbstractGuiEngineContext implements GuiEngineContext {
	
	private ExpressionEvaluator expressionEvaluator;
	
	private Resolver variableResolver;
	
	private ELContext elContext;
	
	private GuiRootComponent root;
	
	private Document screenXmlDocument;
	
	private MessageContext messageContext;
	
	private final Map<String, Variable> screenVariables = new HashMap<String, Variable>();
	
	private ScreenDefinitionParserDelegate delegate;

	private List<Widget> widgets;
	
	public AbstractGuiEngineContext() {
		initializeStrategies();
	}
	
	//Initialize Context XmlScreenConfiguration.
	protected void initializeStrategies() {
		elContext = new DefaultJexlContext();
		
		variableResolver = new ELContextVariableResolver(elContext);
		
		messageContext = new ResourceBundleMessageContext();
		
		delegate = new ScreenDefinitionParserDelegate();
		
		initializeExpressionEvaluator();
	}

	/**
	 * 
	 */
	private void initializeExpressionEvaluator() {
		expressionEvaluator = new SimpleExpressionEvaluator();
		expressionEvaluator.setELContext(elContext);
	}
	
	@Override
	public GuiRootComponent getUIRoot() {
		return root;
	}

	@Override
	public ExpressionEvaluator getExpressionEvaluator() {
		return expressionEvaluator;
	}

	@Override
	public Resolver getVariableResolver() {
		return variableResolver;
	}

	@Override
	public ELContext getELContext() {
		return elContext;
	}

	public void setUIRoot(GuiRootComponent root) {
		this.root = root;
	}

	@Override
	public void registerVariable(String name, Object value) {
		if(root != null) {
			Variable var = new Variable();
			var.setName(name);
			var.setValue(value);
			getScreenVariables().put(name, var);
		}
		elContext.registerELContextVariable(name, value);
	}

	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}

	public Document getScreenXmlDocument() {
		return screenXmlDocument;
	}

	protected void setScreenXmlDocument(Document screenXml) {
		this.screenXmlDocument = screenXml;
	}
	
	@Override
	public PreRenderActions getPreRenderActions() {
		validateScreenXmlDoc();
		
		Element preRenderActionElement = DomUtils.getChildElementByTagName(screenXmlDocument.getDocumentElement(), "pre-actions");
		GuiElementDefinitionParser parser = delegate.getScreenElementDefinitionParser("pre-actions");
		PreRenderActions preRenderActions = parser.parse(preRenderActionElement,PreRenderActions.class);
		return preRenderActions;
	}

	/**
	 * 
	 */
	private void validateScreenXmlDoc() {
		if(screenXmlDocument == null) {
			throw new IllegalStateException("Screen XML Document has not been initialized.!");
		}
	}

	public Map<String, Variable> getScreenVariables() {
		return screenVariables;
	}
	
	public List<Widget> getScreenWidgets() {
		
		if(widgets == null) {
			validateScreenXmlDoc();
			
			widgets = new ArrayList<Widget>();
			
			Element pageContentEle = DomUtils.getChildElementByTagName(screenXmlDocument.getDocumentElement(), "page-content");
			List<Element> list = DomUtils.getChildElementsByTagName(pageContentEle, "widget");
			
			if(list != null) {
				GuiElementDefinitionParser parser = delegate.getScreenElementDefinitionParser("widget");
				for (Element widgetsEle : list) {
					Widget widget = parser.parse(widgetsEle, Widget.class);
					widgets.add(widget);
				}
			}
		}
		return widgets;
	}

}