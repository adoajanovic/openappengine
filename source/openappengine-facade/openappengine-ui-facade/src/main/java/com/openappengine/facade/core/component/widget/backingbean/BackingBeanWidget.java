package com.openappengine.facade.core.component.widget.backingbean;

import com.openappengine.facade.core.component.widget.Widget;

public interface BackingBeanWidget extends Widget {
	
	/**
	 * Get the form backing object for this widget.
	 * @return
	 */
	Object formBackingObject();

}
