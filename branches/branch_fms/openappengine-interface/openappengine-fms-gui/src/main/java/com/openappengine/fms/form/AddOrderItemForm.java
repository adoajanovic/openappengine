/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
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
	
	private OrderItemDTO selectedItemDTO;

	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		setOrderItemDTO(new OrderItemDTO());
		load(new BeanAdapter(getOrderItemDTO()));
	}

	@Override
	protected void initFormActions(Map<String, Object> namespace) {
		PushButton addOrderItemButton = (PushButton) namespace.get("addOrderItemButton");
		addOrderItemButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				//TODO - Perform Validation.
				store(getOrderItemDTO());
				selectedItemDTO = getOrderItemDTO();
				AddOrderItemForm.this.getWindow().close();
			}
		});
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
					BigDecimal orderQty = orderItemDTO.getQuantity();
					BigDecimal total = (orderQty.multiply(dto.getNetPrice())).add((orderQty.multiply(dto.getTaxPrice())));
					BigDecimal totalTax = orderQty.multiply(dto.getTaxPrice());
					
					getOrderItemDTO().setProductName(dto.getProductName());
					getOrderItemDTO().setNetPrice(dto.getNetPrice());
					getOrderItemDTO().setTaxAmount(dto.getTaxPrice());
					getOrderItemDTO().setUnitPrice(dto.getNetPrice());
					getOrderItemDTO().setTotal(total);
					getOrderItemDTO().setTotalTax(totalTax);
					getOrderItemDTO().setProductId(dto.getProductId());
					
					load(new BeanAdapter(getOrderItemDTO()));
				}
			}
		});

		quantity.getTextInputContentListeners().add(new TextInputContentListener.Adapter() {

			
			@Override
			public void textInserted(TextInput textInput, int index, int count) {
				onQuantityValueChange(productName, quantity, total);
			}

			@Override
			public void textRemoved(TextInput textInput, int index, int count) {
				onQuantityValueChange(productName, quantity, total);
			}

			private void onQuantityValueChange(final ListButton productName,
					final TextInput quantityTxt, final TextInput total) {
				String qty = quantityTxt.getText();
				
				if(productName.getSelectedItem() == null) {
					Alert.alert(MessageType.WARNING, "Select Product from the drop-down", getWindow());
				}
				
				if(!NumberUtils.isNumber(qty)) {
					return;
				}
				
				BigDecimal quantity = new BigDecimal(qty);
				getOrderItemDTO().setQuantity(quantity);
				
				ProductItemListDTO dto = (ProductItemListDTO) productName.getSelectedItem();
				
				BigDecimal orderQty = orderItemDTO.getQuantity();
				BigDecimal totalAmt = (orderQty.multiply(dto.getNetPrice())).add((orderQty.multiply(dto.getTaxPrice())));
				BigDecimal totalTax = orderQty.multiply(dto.getTaxPrice());
				BigDecimal netPrice = quantity.multiply(dto.getNetPrice());
				
				getOrderItemDTO().setTotalTax(totalTax);
				getOrderItemDTO().setTotal(totalAmt);
				getOrderItemDTO().setNetPrice(netPrice);
				getOrderItemDTO().setProductId(dto.getProductId());
				
				total.setText(totalAmt.toString());
				load(new BeanAdapter(getOrderItemDTO()));
			}
			
		});
	}

	public OrderItemDTO getOrderItemDTO() {
		return orderItemDTO;
	}

	private void setOrderItemDTO(OrderItemDTO orderItemDTO) {
		this.orderItemDTO = orderItemDTO;
	}

	public OrderItemDTO getSelectedItemDTO() {
		return selectedItemDTO;
	}

	public void setSelectedItemDTO(OrderItemDTO selectedItemDTO) {
		this.selectedItemDTO = selectedItemDTO;
	}
}
