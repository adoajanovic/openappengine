/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Container;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.fms.interfaces.dto.TaxDTO;

/**
 * @author hrishikesh.joshi
 * @since  Apr 2, 2012
 *
 */
public class TaxForm extends FleetManagerForm {

	private TaxDTO taxDTO;
	
	@BXML
	private ListButton taxType;
	
	@BXML
	private TextInput taxPercentage;
	
	@BXML
	private PushButton saveButton;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		
		taxDTO = new TaxDTO();
		load(taxDTO);
		
		saveButton.getButtonPressListeners().add(new ButtonPressListener() {
			
			@Override
			public void buttonPressed(Button button) {
				store(taxDTO);
				getWindow().close();
			}
		});
	}

	public TaxDTO getTaxDTO() {
		return taxDTO;
	}

	public void setTaxDTO(TaxDTO taxDTO) {
		this.taxDTO = taxDTO;
	}

}
