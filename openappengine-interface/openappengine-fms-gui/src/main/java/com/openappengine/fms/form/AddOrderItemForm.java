/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputContentListener;
import org.apache.pivot.wtk.TextInputListener;

import com.openappengine.fms.interfaces.dto.OrderItemDTO;
import com.openappengine.fms.interfaces.dto.ProductItemListDTO;

/**
 * @author hrishi
 *
 */
public class AddOrderItemForm extends FleetManagerForm {
	
	private OrderItemDTO orderItemDTO;

	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		orderItemDTO = new OrderItemDTO();
		load(new BeanAdapter(orderItemDTO));
	}

	@Override
	protected void initFormActions(Map<String, Object> namespace) {
		
	}

	@Override
	protected void initFormElements(Map<String, Object> namespace) {
		ListButton productName = (ListButton) namespace.get("productName");
		TextInput quantity = (TextInput) namespace.get("quantity");
		
		List<ProductItemListDTO> activeProducts = getFleetManagerServiceFacade().getAllActiveProducts();
		productName.setListData(activeProducts);
		
		productName.getListButtonSelectionListeners().add(new ListButtonSelectionListener.Adapter(){

			@Override
			public void selectedItemChanged(ListButton listButton, Object previousSelectedItem) {
				ProductItemListDTO dto = (ProductItemListDTO) listButton.getSelectedItem();
				if(dto != null) {
					orderItemDTO.setNetPrice(dto.getNetPrice());
					orderItemDTO.setTaxAmount(dto.getTaxPrice());
					load(new BeanAdapter(orderItemDTO));
				}
			}
		});
		
		quantity.getTextInputListeners().add(new TextInputListener.Adapter(){
			@Override
			public void textValidChanged(TextInput textInput) {
				String qty = textInput.getText();
				BigDecimal quantity = new BigDecimal(qty);
				BigDecimal totalAmount = quantity.multiply(orderItemDTO.getUnitPrice());
				orderItemDTO.setTotal(totalAmount);
			}
		});
	}
}
