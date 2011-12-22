/**
 * 
 */
package com.openappengine.facade.ui.screen;

import java.io.Serializable;

import com.openappengine.facade.ui.widgets.SubScreen;
import com.openappengine.facade.ui.widgets.container.ContainerPanel;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Screen implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ContainerPanel containerPanel;
	
	private SubScreen activeSubScreen;

	public ContainerPanel getContainerPanel() {
		return containerPanel;
	}

	public void setContainerPanel(ContainerPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

	public SubScreen getActiveSubScreen() {
		return activeSubScreen;
	}

	public void setActiveSubScreen(SubScreen activeSubScreen) {
		this.activeSubScreen = activeSubScreen;
	}

}
