/**
 * 
 */
package com.openappengine.facade.core.component.transition.response;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.value.ParameterComponent;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public abstract class AbstractTransitionalResponse implements GuiComponent {

	private static final long serialVersionUID = 1L;
	
	private String url;
	
	private List<ParameterComponent> parameters = new ArrayList<ParameterComponent>();
	
	private boolean saveCurrentScreen;
	
	@Override
	public String getComponentType() {
		return "transitional-response";
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<GuiComponent> getChildComponents() {
		return null;
	}

	@Override
	public String getId() {
		return null;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ParameterComponent> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterComponent> parameters) {
		this.parameters = parameters;
	}

	public boolean isSaveCurrentScreen() {
		return saveCurrentScreen;
	}

	public void setSaveCurrentScreen(boolean saveCurrentScreen) {
		this.saveCurrentScreen = saveCurrentScreen;
	}
}
