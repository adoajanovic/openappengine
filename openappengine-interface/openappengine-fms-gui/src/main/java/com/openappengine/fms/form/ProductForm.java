/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Dimensions;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.WindowStateListener;

import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.TaxDTO;
import com.openappengine.fms.util.PivotUtils;

/**
 * @author hrishi
 *
 */
public class ProductForm extends FleetManagerForm {
	
	private ProductDTO productDTO;
	
	@BXML
	private ListButton taxable;
	
	@BXML
	private PushButton saveButton;
	
	@BXML
	private LinkButton addTaxButton;
	
	private Form taxForm;
	
	private Dialog dialog;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		
		taxable.setSelectedItem("Yes");
		
		saveButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				source.getWindow().store(new BeanAdapter(productDTO));
				System.out.println(productDTO);
			}
		});
		
		addTaxButton.setAction(new Action() {
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
						TaxDTO taxDTO = ((TaxForm)taxForm).getTaxDTO();
					}
					
				});
				dialog.open(getWindow());
			}
		});
		
		productDTO = new ProductDTO();
		productDTO.setProductName("Example");
		this.load(new BeanAdapter(productDTO));
	}
}