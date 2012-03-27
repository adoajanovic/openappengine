/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.TextInput;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class CustomerForm extends Form implements Bindable {
	
	@BXML
	private TextInput firstName;
	@BXML
	private TextInput middleName;
	@BXML
	private TextInput lastName;
	@BXML
	private ListButton gender;
	@BXML
	private TextInput address1;
	@BXML
	private TextInput address2;
	@BXML
	private TextInput city;
	@BXML
	private TextInput state;
	@BXML
	private TextInput country;
	@BXML
	private TextInput zip;
	@BXML
	private ListButton addressType1;
	@BXML
	private TextInput infoString1;
	@BXML
	private ListButton addressType2;
	@BXML
	private TextInput infoString2;
	@BXML
	private TextInput email1;
	@BXML
	private TextInput email2;

	
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {
		
	}

}
