/**
 * 
 */
package com.openappengine.facade.ui.screen;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.params.Parameters;
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
	
	private Parameters screenParameters = new Parameters();
	
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

	public Parameters getScreenParameters() {
		return screenParameters;
	}

	public void setScreenParameters(Parameters screenParameters) {
		this.screenParameters = screenParameters;
	}
	
	public void addScreenParameter(Param param,Object value) {
		if(param == null) {
			return;
		}
		
		screenParameters.setParam(param, value);
	}

}
