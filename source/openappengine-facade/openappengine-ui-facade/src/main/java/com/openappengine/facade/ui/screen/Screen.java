/**
 * 
 */
package com.openappengine.facade.ui.screen;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.ui.params.Params;
import com.openappengine.facade.ui.widgets.SubScreen;
import com.openappengine.facade.ui.widgets.Widget;
import com.openappengine.facade.ui.widgets.container.ContainerPanel;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Screen implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ContainerPanel containerPanel;
	
	private SubScreen activeSubScreen;
	
	private Map<String, Widget> containerWidgetMap = new HashMap<String, Widget>();
	
	private Params screenParameters;
	
	private Map<String,String[]> requestParameters;

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

	public Map<String, Widget> getContainerWidgetMap() {
		return containerWidgetMap;
	}

	public void setContainerWidgetMap(Map<String, Widget> containerWidgetMap) {
		this.containerWidgetMap = containerWidgetMap;
	}

	public void addWidget(String containerId, Widget widget) {
		if(StringUtils.isEmpty(containerId) || widget == null) {
			return;
		}
		
		this.containerWidgetMap.put(containerId, widget);
	}

	public Params getScreenParameters() {
		return screenParameters;
	}

	public void setScreenParameters(Params screenParameters) {
		this.screenParameters = screenParameters;
	}

	public Map<String, String[]> getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(Map<String, String[]> requestParameters) {
		this.requestParameters = requestParameters;
	}
}
