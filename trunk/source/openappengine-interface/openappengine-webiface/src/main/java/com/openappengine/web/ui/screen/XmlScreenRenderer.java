/**
 * 
 */
package com.openappengine.web.ui.screen;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.openappengine.facade.ui.screen.Screen;
import com.openappengine.web.annotations.PreRenderView;
import com.openappengine.web.filter.PerViewPhaseListener;
import com.openappengine.web.filter.ScreenThreadLocalContext;


/**
 * @author hrishi
 *
 */
public class XmlScreenRenderer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	private PerViewPhaseListener phaseListener;
	
	private Screen screen;
	
	public XmlScreenRenderer(){
		phaseListener = new PerViewPhaseListener(this);
		setScreen(ScreenThreadLocalContext.get());
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
		if(screen == null) {
			logger.error("No Screen found..Aborting Screen Processing");
		}
	}	

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	
}
