/**
 * 
 */
package com.openappengine.fms.form;

import org.apache.pivot.beans.Bindable;
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
}
