/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputContentListener;

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
		final ListButton productName = (ListButton) namespace.get("productName");
		final TextInput quantity = (TextInput) namespace.get("quantity");
		final TextInput total = (TextInput) namespace.get("total");
		
		List<ProductItemListDTO> activeProducts = getFleetManagerServiceFacade().getAllActiveProducts();
		productName.setListData(activeProducts);
		
		productName.getListButtonSelectionListeners().add(new ListButtonSelectionListener.Adapter(){

			@Override
			public void selectedItemChanged(ListButton listButton, Object previousSelectedItem) {
				ProductItemListDTO dto = (ProductItemListDTO) listButton.getSelectedItem();
				if(dto != null) {
					orderItemDTO.setNetPrice(dto.getNetPrice());
					orderItemDTO.setTaxAmount(dto.getTaxPrice());
					BigDecimal total = dto.getNetPrice().add(dto.getTaxPrice());
					orderItemDTO.setUnitPrice(total);
					
					load(new BeanAdapter(orderItemDTO));
				}
			}
		});

		quantity.getTextInputContentListeners().add(new TextInputContentListener.Adapter() {

			
			@Override
			public void textInserted(TextInput textInput, int index, int count) {
				String qty = quantity.getText();
				
				if(productName.getSelectedItem() == null) {
					Alert.alert(MessageType.WARNING, "Select Product from the drop-down", getWindow());
				}
				if(!NumberUtils.isNumber(qty)) {
					return;
				}
				
				BigDecimal quantity = new BigDecimal(qty);
				orderItemDTO.setQuantity(quantity);
				
				BigDecimal totalAmount = quantity.multiply(orderItemDTO.getUnitPrice());
				orderItemDTO.setTotal(totalAmount);
				total.setText(totalAmount.toString());
				load(new BeanAdapter(orderItemDTO));
			}

			@Override
			public void textRemoved(TextInput textInput, int index, int count) {
				String qty = quantity.getText();
				
				if(productName.getSelectedItem() == null) {
					Alert.alert(MessageType.WARNING, "Select Product from the drop-down", getWindow());
				}
				
				if(!NumberUtils.isNumber(qty)) {
					return;
				}
				
				BigDecimal quantity = new BigDecimal(qty);
				orderItemDTO.setQuantity(quantity);
				
				BigDecimal totalAmount = quantity.multiply(orderItemDTO.getUnitPrice());
				orderItemDTO.setTotal(totalAmount);
				total.setText(totalAmount.toString());
				load(new BeanAdapter(orderItemDTO));
			}
			
		});
	}
}
