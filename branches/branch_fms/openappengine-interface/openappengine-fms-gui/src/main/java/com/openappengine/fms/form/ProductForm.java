/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Dictionary;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dimensions;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.content.ListItem;

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
		
		productDTO = new ProductDTO();
		this.load(new BeanAdapter(productDTO));
	}
}