/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.renderer.ScreenRenderer;
import com.openappengine.gui.engine.core.renderer.WebXmlScreenRenderer;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.fsm.TransitionEventListener;
import com.openappengine.gui.engine.fsm.WebTransitionEventListener;

/**
 * The XmlScreenApplicationContext for the Web JEE Environment.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebGuiApplicationContext extends AbstractGuiEngineContext {

	protected ScreenRenderer screenRenderer;
	
	protected ExternalContext externalContext;
	
	protected TransitionEventListener transitionEventListener;
	
	//Metadata
	protected final Map<String,List<Widget>> referencedWidgets = new ConcurrentHashMap<String, List<Widget>>();
	
	public WebGuiApplicationContext(Document document) {
		Assert.notNull(document,"Screen Xml Document could not be created..!");
		this.setScreenXmlDocument(document);
	}

	/**
	 * Initializations for the JEE environment.
	 */
	public void postRootConstruction() {
		screenRenderer = new WebXmlScreenRenderer();
		/*transitionEventListener = new WebTransitionEventListener(getUIRoot());
		transitionEventListener.setExpressionEvaluator(getExpressionEvaluator());*/
	}
	
	@Override
	public ExternalContext getExternalContext() {
		return externalContext;
	}

	@Override
	public TransitionEventListener getTransitionEventListener() {
		return transitionEventListener;
	}

	/**
	 * @param transitionEventListener the transitionEventListener to set
	 */
	public void setTransitionEventListener(TransitionEventListener transitionEventListener) {
		this.transitionEventListener = transitionEventListener;
	}

	@Override
	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	public void addValueReferencedWidget(String valueRef, Widget widget) {
		if(StringUtils.isEmpty(valueRef) || widget == null) {
			return;
		}
		
		if(referencedWidgets.containsKey(valueRef)) {
			getReferencedWidgets(valueRef).add(widget);
		} else {
			List<Widget> widgets = new ArrayList<Widget>();
			widgets.add(widget);
			referencedWidgets.put(valueRef, widgets);
		}
	}

	@Override
	public List<Widget> getReferencedWidgets(String valueRef) {
		if(StringUtils.isEmpty(valueRef)) {
			return null;
		}
		return referencedWidgets.get(valueRef);
	}
	
}
