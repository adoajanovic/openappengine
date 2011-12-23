/**
 * 
 */
package com.openappengine.web.ui.screen;

import java.io.Serializable;

import com.openappengine.web.filter.PerViewPhaseListener;


/**
 * @author hrishi
 *
 */
public class XmlScreenRenderer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PerViewPhaseListener phaseListener;
	
	public XmlScreenRenderer(){
		phaseListener = new PerViewPhaseListener(this);
	}

	public PerViewPhaseListener getPhaseListener() {
		return phaseListener;
	}

	public void setPhaseListener(PerViewPhaseListener phaseListener) {
		this.phaseListener = phaseListener;
	}

}
