/**
 * 
 */
package com.openappengine.facade.core.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import com.openappengine.facade.core.component.widget.Widget;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.renderer.ScreenRenderer;
import com.openappengine.facade.core.renderer.WebXmlScreenRenderer;
import com.openappengine.facade.fsm.WebTransitionEventListener;
import com.openappengine.facade.fsm.TransitionEventListener;

/**
 * The XmlScreenApplicationContext for the Web JEE Environment.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class WebGuiApplicationContext extends AbstractGuiApplicationContext {

	protected ScreenRenderer screenRenderer;
	
	protected ExternalContext externalContext;
	
	protected TransitionEventListener transitionEventListener;
	
	protected final Map<String,List<Widget>> referencedWidgets = new ConcurrentHashMap<String, List<Widget>>();
	
	public WebGuiApplicationContext() {
	}

	/**
	 * Initializations for the JEE environment.
	 */
	public void postRootConstruction() {
		screenRenderer = new WebXmlScreenRenderer();
		transitionEventListener = new WebTransitionEventListener(getUIRoot());
		transitionEventListener.setExpressionEvaluator(getExpressionEvaluator());
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

	@Override
	public void addValueReferencedWidgets(String valueRef, List<Widget> widgets) {
		if(StringUtils.isEmpty(valueRef) || widgets == null) {
			return;
		}
		
		referencedWidgets.put(valueRef, widgets);
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
			addValueReferencedWidgets(valueRef, widgets);
		}
	}

	@Override
	public List<Widget> getReferencedWidgets(String valueRef) {
		if(StringUtils.isEmpty(valueRef)) {
			return null;
		}
		return referencedWidgets.get(valueRef);
	}

	@Override
	public Document getScreenXmlDocument() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
