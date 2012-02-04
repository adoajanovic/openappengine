/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;


/**
 * @author hrishi
 * since Jan 29, 2012
 */
public abstract class AbstractEntityActionComponent extends AbstractExecutableComponent {
	
	private static final long serialVersionUID = 1L;

	@Override
	public ActionRequest createActionRequest() {
		
		return null;
	}

}
