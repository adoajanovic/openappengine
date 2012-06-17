/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import com.openappengine.entity.api.ValueEntity;

/**
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public class WidgetHelper {
	
	public Object getValue(ValueEntity valueEntity,String field) {
		return valueEntity.get(field);
	}

}
