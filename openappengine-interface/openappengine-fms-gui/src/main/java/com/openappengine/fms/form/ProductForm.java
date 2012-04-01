/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.pivot.beans.BXML;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.fms.interfaces.dto.ProductDTO;

/**
 * @author hrishi
 *
 */
public class ProductForm extends FleetManagerForm {
	
	private ProductDTO productDTO;
	
	@BXML
	private ListButton taxable;
	
	@BXML
	private ListButton taxType;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		
		BoxPane totalAmountBox = (BoxPane) namespace.get("totalAmountBox");
		totalAmountBox.setEnabled(false);
		
		taxable.setSelectedItem("Yes");
		BoxPane taxBox = (BoxPane) namespace.get("taxBox");
		taxBox.setVisible(true);
		
		TextInput totalTax = (TextInput) namespace.get("totalTax");
		totalTax.setText("0.00");
		
		taxable.getListButtonSelectionListeners().add(new ListButtonSelectionListener.Adapter(){
			@Override
			public void selectedItemChanged(ListButton listButton,Object previousSelectedItem) {
				String selectedItem = (String) taxable.getSelectedItem();
				BoxPane taxBox = (BoxPane) namespace.get("taxBox");
				if(StringUtils.equals(selectedItem, "Yes")) {
					taxBox.setVisible(true);
				} else {
					taxBox.setVisible(false);
				}
			}
		});
		
		taxType.getListButtonSelectionListeners().add(new ListButtonSelectionListener.Adapter() {
			@Override
			public void selectedItemChanged(ListButton listButton,
					Object previousSelectedItem) {
				String taxType = (String) listButton.getSelectedItem();
				if(StringUtils.equals(taxType, "")) {
					
				} else {
					
				}
			}
		});
		
	}

}
