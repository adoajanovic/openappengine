/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.CalendarButton;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputContentListener;
import org.springframework.util.NumberUtils;

import com.openappengine.fms.interfaces.dto.ProductAmountDTO;
import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.ProductTypeDTO;
import com.openappengine.utility.DateTimeUtil;

/**
 * @author hrishi
 *
 */
public class ProductForm extends FleetManagerForm {
	
	private ProductDTO productDTO;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		initFormBean(namespace);
		
		final ListButton productType = (ListButton) namespace.get("productType");
		final TextInput netAmount = (TextInput) namespace.get("netAmount");
		final PushButton resetButton = (PushButton) namespace.get("resetButton");
		final PushButton saveButton = (PushButton) namespace.get("saveButton");
		
		setFormDefaults(namespace);
		
		netAmount.getTextInputContentListeners().add(new TextInputContentListener.Adapter() {
			@Override
			public void textInserted(TextInput textInput, int index, int count) {
				ProductTypeDTO productTypeDTO = (ProductTypeDTO) productType.getSelectedItem();
				if(productTypeDTO == null) {
					return;
				}
				
				BigDecimal netPrice;
				try {
					netPrice = NumberUtils.parseNumber(netAmount.getText(), BigDecimal.class);
				} catch (Exception e) {
					resetAmounts(namespace);
					Alert.alert(MessageType.ERROR, "Invalid Value for Price (Net).", ProductForm.this.getWindow());
					return;
				}
				
				ProductForm.this.store(productDTO);

				ProductAmountDTO productAmountDTO = getFleetManagerServiceFacade().calculateTaxAmount(productTypeDTO, netPrice);
				
				productDTO.setNetPrice(productAmountDTO.getPriceNet());
				productDTO.setGrossPrice(productAmountDTO.getPriceGross());
				productDTO.setTaxAmount(productAmountDTO.getCalculatedTax());
				
				ProductForm.this.load(new BeanAdapter(productDTO));
			}
		});
		
		resetButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				initForm(namespace);
			}
		});
		
		saveButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				ProductTypeDTO productTypeDTO = (ProductTypeDTO) productType.getSelectedItem();
				java.util.List<String> msgs = new java.util.ArrayList<String>();
				if(productTypeDTO == null) {
					msgs.add("Please select the Product Type.");
				}
				productDTO.setProductTypeDTO(productTypeDTO);
				
				try {
					ProductForm.this.store(productDTO);
				} catch (Exception e) {
					msgs.add("Error in validation.");
				}
				
				try {
					getFleetManagerServiceFacade().addNewProduct(productDTO);
				} catch (Exception e) {
					Alert.alert(MessageType.ERROR, "Error encountered while saving the product.", ProductForm.this.getWindow());
					return;
				}
				Alert.alert(MessageType.INFO, "Product Saved.", ProductForm.this.getWindow());
			}
		});
		
		this.load(new BeanAdapter(productDTO));
	}
	
	private void resetAmounts(final Map<String, Object> namespace) {
		TextInput netAmount = (TextInput) namespace.get("netAmount");
		netAmount.setText("0.0");
		
		TextInput tax = (TextInput) namespace.get("tax");
		tax.setText("0.0");
		
		TextInput grossAmount = (TextInput) namespace.get("grossAmount");
		grossAmount.setText("0.0");
	}
	
	private void initForm(final Map<String, Object> namespace) {
		initFormBean(namespace);
		setFormDefaults(namespace);
		ProductForm.this.load(new BeanAdapter(productDTO));
	}

	private void setFormDefaults(final Map<String, Object> namespace) {
		final CalendarButton introductionCalDate = (CalendarButton) namespace.get("introductionDate");
		final CalendarButton discontinuationCalDate = (CalendarButton) namespace.get("discontinuationDate");
		final ListButton productType = (ListButton) namespace.get("productType");
		
		introductionCalDate.setSelectedDate(DateTimeUtil.toDateString(productDTO.getIntroductionDate(), "yyyy-MM-dd"));
		discontinuationCalDate.setSelectedDate(DateTimeUtil.toDateString(productDTO.getSalesDiscontinuationDate(), "yyyy-MM-dd"));
		initProductTypeList(productType);
	}

	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		productDTO = new ProductDTO();
		Date introductionDate = new Date();
		Date salesDiscontinuationDate = DateUtils.addDays(introductionDate, 365);
		productDTO.setIntroductionDate(introductionDate);
		productDTO.setSalesDiscontinuationDate(salesDiscontinuationDate);
	}

	private void initProductTypeList(ListButton productType) {
		List<Object> listData = new ArrayList<Object>();
		java.util.List<ProductTypeDTO> productTypes = getFleetManagerServiceFacade().loadAllProductTypes();
		if(productTypes != null) {
			for (ProductTypeDTO productTypeDTO : productTypes) {
				listData.add(productTypeDTO);
			}
		}
		productType.setListData(listData);
	}
}