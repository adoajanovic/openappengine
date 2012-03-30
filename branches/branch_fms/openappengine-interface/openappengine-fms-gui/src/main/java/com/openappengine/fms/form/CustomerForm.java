/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.HashMap;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.CalendarButton;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.DateTimeUtil;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class CustomerForm extends Form implements Bindable {
	@BXML
	private ListButton salutation;
	@BXML
	private TextInput firstName;
	@BXML
	private TextInput middleName;
	@BXML
	private TextInput lastName;
	@BXML
	private CalendarButton birthDate;
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
	private ListButton phoneType1;
	@BXML
	private TextInput infoString1;
	@BXML
	private ListButton phoneType2;
	@BXML
	private TextInput infoString2;
	@BXML
	private TextInput email1;
	@BXML
	private TextInput email2;
	@BXML
	private PushButton saveButton;
	@BXML
	private PushButton resetButton;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		
		Integer customerId = (Integer) namespace.get("CustomerId");
		if(customerId != null) {
			saveButton.setButtonData("Update");
			ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
			
			java.util.Map<String, Object> context = new HashMap<String, Object>();
			java.util.Map<String, Object> resultMap = new HashMap<String, Object>();
			try {
				context.put("personId", customerId);
				resultMap = sd.runSync("party.findPersonById", context);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
			}
			
			Person p = (Person) resultMap.get("person");
			refreshFormData(p);
		}
		
		saveButton.setAction(new Action() {
			
			@Override
			public void perform(Component c) {
				Integer customerId = (Integer) namespace.get("CustomerId");
				Person party = new Person();
				party.setBirthDate(birthDate.getSelectedDate().toCalendar().getTime());
				party.setFirstName(firstName.getText());
				party.setMiddleName(middleName.getText());
				party.setLastName(lastName.getText());
				party.setGender(gender.getSelectedItem().toString());
				party.setPreferredCurrencyUom("INR");
				party.setSalutation((String) salutation.getSelectedItem());
				
				PartyContactMech partyContactMech = new PartyContactMech();
				partyContactMech.setContactMechPurpose("DEFAULT");
				partyContactMech.setContactMechType((String) phoneType1.getSelectedItem());
				partyContactMech.setInfoString(infoString1.getText());
				
				String serviceName = "";
				if(customerId != null) {
					party.setPartyId(customerId);
					serviceName = "party.updatePerson";
				} else {
					serviceName = "party.createPerson";
				}
				
				ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
				java.util.Map<String, Object> context = new HashMap<String, Object>();
				context.put("person", party);
				try {
					sd.runSync(serviceName, context);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				refreshFormData(party);
			}
			
		});
		
	}

	/**
	 * @param resultMap
	 */
	private void refreshFormData(Person p) {
		if(p != null) {
			salutation.setSelectedItem(p.getSalutation());
			firstName.setText(p.getFirstName());
			middleName.setText(p.getMiddleName());
			lastName.setText(p.getLastName());
			birthDate.setSelectedDate(DateTimeUtil.toDateString(p.getBirthDate(), "yyyy-MM-dd"));
			gender.setSelectedItem(p.getGender());
			saveButton.setButtonData("Update");
		}
	}

}
