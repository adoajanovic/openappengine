/**
 * 
 */
package com.openappengine.web.gui.controller;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.web.annotations.PreRenderView;
import com.openappengine.web.filter.PerViewPhaseListener;
import com.openappengine.web.request.GuiApplicationContextAwareHttpServletRequest;


/**
 * @author hrishi
 *
 */
public class XmlScreenRenderer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	private PerViewPhaseListener phaseListener;

	private GuiRootComponent uiRoot;
	
	public XmlScreenRenderer(){
		phaseListener = new PerViewPhaseListener(this);
		initializeUIRoot();
	}

	/**
	 *  Initialize the UIRoot object.
	 */
	protected void initializeUIRoot() {
		ExternalContext facesExternalContext = extractCurrentFacesContextInstance().getExternalContext();
		Object request = facesExternalContext.getRequest();
		if(request.getClass().isAssignableFrom(GuiApplicationContextAwareHttpServletRequest.class)) {
			GuiApplicationContextAwareHttpServletRequest wrappedRequest = (GuiApplicationContextAwareHttpServletRequest) request;
			GuiApplicationContext guiApplicationContext = wrappedRequest.getGuiApplicationContext();
			if(guiApplicationContext != null) {
				setUiRoot(guiApplicationContext.getUIRoot());
			}
		}
	}

	/**
	 * @return FacesContext current instance.
	 */
	protected FacesContext extractCurrentFacesContextInstance() {
		return FacesContext.getCurrentInstance();
	}

	public PerViewPhaseListener getPhaseListener() {
		return phaseListener;
	}

	public void setPhaseListener(PerViewPhaseListener phaseListener) {
		this.phaseListener = phaseListener;
	}

	@PreRenderView
	public void handleScreenPreRenderProcessing() {
		logger.info("Screen PreRender Processing Started...");
	}

	public GuiRootComponent getUiRoot() {
		return uiRoot;
	}

	public void setUiRoot(GuiRootComponent uiRoot) {
		this.uiRoot = uiRoot;
	}	
	
	
}
