/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Form;

import com.openappengine.fms.interfaces.FleetManagerServiceFacade;
import com.openappengine.fms.interfaces.FleetManagerServiceFacadeImpl;

/**
 * @author hrishi
 *
 */
public abstract class FleetManagerForm extends Form implements Bindable {

	private FleetManagerServiceFacade fleetManagerServiceFacade = new FleetManagerServiceFacadeImpl();
	
	private Mode formMode;
	
	private Logger logger = Logger.getLogger(getClass());
	
	public enum Mode {
		VIEW,
		EDIT,
		NEW
	}
	
	public FleetManagerServiceFacade getFleetManagerServiceFacade() {
		return fleetManagerServiceFacade;
	}

	public void setFleetManagerServiceFacade(FleetManagerServiceFacade fleetManagerServiceFacade) {
		this.fleetManagerServiceFacade = fleetManagerServiceFacade;
	}

	public Mode getFormMode() {
		return formMode;
	}

	public void setFormMode(Mode formMode) {
		this.formMode = formMode;
	}
	
	public boolean isEditMode() {
		return Mode.EDIT.equals(formMode);
	}
	
	public boolean isNewMode() {
		return Mode.NEW.equals(formMode);
	}

	protected void initFormBean(Map<String, Object> namespace) {
	}
	
	protected void initFormActions(Map<String, Object> namespace) {
	}

	protected void initFormElements(Map<String, Object> namespace) {
	}
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {
		initFormBean(namespace);
		initFormActions(namespace);
		initFormElements(namespace);
	}
}
