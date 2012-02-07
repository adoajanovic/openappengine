/**
 * 
 */
package com.openappengine.facade.core.executor.action.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.annotations.EntityMode;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class DefaultActionHandlerFactory implements ActionHandlerFactory {
	
	private static final Map<String,ActionHandler> cachedActionHandlers = new ConcurrentHashMap<String, ActionHandler>();
	
	private static final Map<ActionHandlerParams,ActionHandler> registeredActionHandlers = new ConcurrentHashMap<ActionHandlerParams, ActionHandler>();
	
	@Override
	public ActionHandler getActionHandler(String name) {
		if(!cachedActionHandlers.containsKey(name)) {
			throw new ActionRegistryExecption("ActionHandler : " + name + " not found in the ActionHandlerFactory.");
		}
		return cachedActionHandlers.get(name);
	}
	

	@Override
	public void registerActionHandler(String name, ActionHandler actionHandler) {
		cachedActionHandlers.put(name, actionHandler);
	}
	
	public void registerActionHandler(String actionName,EntityMode entityMode,ActionHandler actionHandler) {
		ActionHandlerParams params = new ActionHandlerParams(actionName, entityMode);
		registeredActionHandlers.put(params, actionHandler);
	}

	@Override
	public ActionHandler getActionHandler(String actionName, EntityMode mode) {
		return null;
	}

	private class ActionHandlerParams {
		
		private String actionName;
		
		private EntityMode entityMode;
		
		/**
		 * @param actionName
		 * @param entityMode
		 */
		public ActionHandlerParams(String actionName, EntityMode entityMode) {
			super();
			this.actionName = actionName;
			this.entityMode = entityMode;
		}

		public String getActionName() {
			return actionName;
		}

		public void setActionName(String actionName) {
			this.actionName = actionName;
		}

		public EntityMode getEntityMode() {
			return entityMode;
		}

		public void setEntityMode(EntityMode entityMode) {
			this.entityMode = entityMode;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((actionName == null) ? 0 : actionName.hashCode());
			result = prime * result
					+ ((entityMode == null) ? 0 : entityMode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ActionHandlerParams other = (ActionHandlerParams) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (actionName == null) {
				if (other.actionName != null)
					return false;
			} else if (!actionName.equals(other.actionName))
				return false;
			if (entityMode != other.entityMode)
				return false;
			return true;
		}

		private DefaultActionHandlerFactory getOuterType() {
			return DefaultActionHandlerFactory.this;
		}
		
	}
}
