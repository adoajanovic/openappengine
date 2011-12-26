package com.openappengine.facade.ui.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.ui.action.entity.EntityFindOneAction;
import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.preaction.PreAction;

public class PreActionHandler implements Executable {
	
	private List<PreAction> preActions = new ArrayList<PreAction>();
	
	@Override
	public Object execute(ScreenContext screenContext) {
		//Handle the preactions.
		if(!preActions.isEmpty()) {
			for (PreAction preAction : preActions) {
				
				//Invoke the PreAction and store the variable in the current screen context.
				Object returnVal = preAction.execute(screenContext);
				
				if(preAction instanceof EntityFindOneAction) {
					EntityFindOneAction entityFindOneAction = (EntityFindOneAction)preAction;
					if(!StringUtils.isEmpty(entityFindOneAction.getValueField())) {
						screenContext.putVariable(entityFindOneAction.getValueField(), returnVal);
					}
				}
			}
		}
		return null;
	}

	public List<PreAction> getPreActions() {
		return preActions;
	}

	public void setPreActions(List<PreAction> preActions) {
		this.preActions = preActions;
	}

	public void addPreAction(PreAction preAction) {
		if(preAction == null) {
			return;
		}
		
		this.preActions.add(preAction);
	}
}
