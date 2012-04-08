/**
 * 
 */
package com.openappengine.fms.form;

import org.apache.pivot.collections.Map;

import com.openappengine.fms.interfaces.dto.OrderItemDTO;

/**
 * @author hrishi
 *
 */
public class AddOrderItemForm extends FleetManagerForm {
	
	private OrderItemDTO orderItemDTO;

	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		orderItemDTO = new OrderItemDTO();
	}

	@Override
	protected void initFormActions(Map<String, Object> namespace) {
		
	}

}
