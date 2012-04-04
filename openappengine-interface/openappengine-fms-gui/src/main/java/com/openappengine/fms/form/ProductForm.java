/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;
import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Button.State;
import org.apache.pivot.wtk.ButtonStateListener;
import org.apache.pivot.wtk.Checkbox;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputListener;

import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.ProductTypeDTO;

/**
 * @author hrishi
 *
 */
public class ProductForm extends FleetManagerForm {
	
	private ProductDTO productDTO;
	
	@BXML
	private ListButton productType;
	
	@BXML
	private PushButton saveButton;
	
	@BXML
	private PushButton resetButton;
	
	@BXML
	private Checkbox includesTax;
	
	@BXML
	private TextInput priceNet;
	
	@BXML
	private TextInput priceGross;
	
	@BXML
	private TextInput tax;
	
	@BXML
	private TextInput amount;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		
		saveButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				ProductTypeDTO productTypeDTO = (ProductTypeDTO) productType.getSelectedItem();
				productDTO.setProductTypeDTO(productTypeDTO);
				
				source.getWindow().store(new BeanAdapter(productDTO));
				
				getFleetManagerServiceFacade().addNewProduct(productDTO);
				
			}
		});
		
		resetButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				productDTO = new ProductDTO();
				ProductForm.this.load(new BeanAdapter(productDTO));
			}
		});
		
		List<Object> listData = new ArrayList<Object>();
		java.util.List<ProductTypeDTO> productTypes = getFleetManagerServiceFacade().loadAllProductTypes();
		if(productTypes != null) {
			for (ProductTypeDTO productTypeDTO : productTypes) {
				listData.add(productTypeDTO);
			}
		}
		productType.setListData(listData);
		productType.setSelectedItem("Service");
		
		/*addTaxButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				Map<String, Object> windowNS = new HashMap<String, Object>();
				taxForm = (Form) PivotUtils.readObject("AddTaxPopup.bxml", windowNS);
				
				dialog = new Dialog(true);
				dialog.setContent(taxForm);
				dialog.setSize(new Dimensions(50, 50));
				dialog.getWindowStateListeners().add(new WindowStateListener.Adapter() {
					
					@Override
					public void windowClosed(Window window, Display display,
							Window owner) {
						taxDTO = ((TaxForm)taxForm).getTaxDTO();
						if(taxDTO != null) {
							taxPanel.load(new BeanAdapter(taxDTO));
						}
					}
					
				});
				dialog.open(getWindow());
			}
		});*/
		
		priceNet.setText("0.0");
		priceGross.setText("0.0");
		tax.setText("0.0");
		
		priceNet.getTextInputListeners().add(new TextInputListener.Adapter() {

			@Override
			public void textValidChanged(TextInput textInput) {
				ProductTypeDTO dto = (ProductTypeDTO) productType.getSelectedItem();
				if(dto == null) {
					return;
				}
				
				ProductForm.this.store(productDTO);
				BigDecimal taxAmount = getFleetManagerServiceFacade().calculateTaxAmount(dto,new BigDecimal(priceNet.getText()));
				productDTO.setTaxAmount(taxAmount);
				ProductForm.this.load(new BeanAdapter(productDTO));
			}
		});
		
		includesTax.getButtonStateListeners().add(new ButtonStateListener() {
			
			@Override
			public void stateChanged(Button button, State previousState) {
				State state = button.getState();
				ProductForm.this.store(productDTO);
				
				ProductTypeDTO dto = (ProductTypeDTO) productType.getSelectedItem();
				if(dto == null) {
					return;
				}
				if(State.UNSELECTED.equals(state)) {
					BigDecimal taxAmount = getFleetManagerServiceFacade().calculateTaxAmount(dto,new BigDecimal(priceNet.getText()));
					productDTO.setTaxAmount(taxAmount);
				} else {
					
				}
				ProductForm.this.load(new BeanAdapter(productDTO));	
			}
		});
		
		productDTO = new ProductDTO();
		this.load(new BeanAdapter(productDTO));
	}
}