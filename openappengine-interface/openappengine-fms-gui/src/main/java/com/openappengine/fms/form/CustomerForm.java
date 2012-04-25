/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.pivot.beans.BXML;
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

import com.openappengine.fms.interfaces.dto.AddressDTO;
import com.openappengine.fms.interfaces.dto.ContactMechDTO;
import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.utility.DateTimeUtil;

/**
 * @author hrishikesh.joshi
 * @since  Mar 27, 2012
 *
 */
public class CustomerForm extends FleetManagerForm {
	
	//DTO
	private CustomerDTO dto;
	
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
		if(customerId != null && customerId.intValue() != 0) {
			this.setFormMode(Mode.EDIT);
			
			dto = getFleetManagerServiceFacade().loadCustomerDTO(customerId);
			refreshFormData(dto);
			
			saveButton.setButtonData("Edit");
		} else {
			this.setFormMode(Mode.NEW);
			
			saveButton.setButtonData("Save");
		}
		
		//TODO
		initSaveAction(namespace);
		
	}

	private void initSaveAction(final Map<String, Object> namespace) {
		saveButton.setAction(new Action() {
			
			@Override
			public void perform(Component c) {
				if(isNewMode()) {
					dto = new CustomerDTO();
				}
				dto.setBirthDate(birthDate.getSelectedDate().toCalendar().getTime());
				dto.setFirstName(firstName.getText());
				dto.setMiddleName(middleName.getText());
				dto.setLastName(lastName.getText());
				dto.setGender(gender.getSelectedItem() != null?gender.getSelectedItem().toString():null);
				dto.setSalutation((String) salutation.getSelectedItem());
				
				List<ContactMechDTO> contactMechs = new java.util.ArrayList<ContactMechDTO>();
				
				List<ContactMechDTO> partyContactMechs = dto.getContactMechDTOs();
				List<ContactMechDTO> phones = new java.util.ArrayList<ContactMechDTO>();
				List<ContactMechDTO> emails = new java.util.ArrayList<ContactMechDTO>();
				
				if(partyContactMechs != null) {
					for (ContactMechDTO dto : partyContactMechs) {
						if(StringUtils.startsWith(dto.getContactMechType(),"PHONE_")) {
							phones.add(dto);
						} else if(StringUtils.equals(dto.getContactMechType(), "EMAIL")) {
							emails.add(dto);
						}
					}
				}
				
				ContactMechDTO partyContactMech;
				if(phones.size() > 0) {
					partyContactMech = phones.get(0);
				} else {
					partyContactMech = new ContactMechDTO();
				}
				
				if(phoneType1.getSelectedItem() != null) {
					partyContactMech = new ContactMechDTO();
					if(!StringUtils.isEmpty(infoString1.getText())) {
						String type1 = (String) phoneType1.getSelectedItem();
						String phone1 = infoString1.getText();
						partyContactMech.setContactMechPurpose("DEFAULT");
						partyContactMech.setContactMechType("PHONE_" + type1);
						partyContactMech.setInfoString(phone1);
						contactMechs.add(partyContactMech);
					} else {
						Alert.alert(MessageType.ERROR, "Phone No. 1 not provided.", getWindow());
						return;
					}
				}
				
				if(phoneType2.getSelectedItem() != null) {
					partyContactMech = new ContactMechDTO();
					if(!StringUtils.isEmpty(infoString2.getText())) {
						String type2 = (String) phoneType2.getSelectedItem();
						String phone2 = infoString2.getText();
						partyContactMech.setContactMechPurpose("DEFAULT");
						partyContactMech.setContactMechType("PHONE_" + type2);
						partyContactMech.setInfoString(phone2);
						contactMechs.add(partyContactMech);
					} else {
						Alert.alert(MessageType.ERROR, "Phone No. 2 not provided.", getWindow());
						return;
					}
				}
				
				
				if(emails.size() > 0) {
					partyContactMech = emails.get(0);
				} else {
					partyContactMech = new ContactMechDTO();
				}
				String emailTxt1 = email1.getText();
				partyContactMech.setContactMechPurpose("DEFAULT");
				partyContactMech.setContactMechType("EMAIL");
				partyContactMech.setInfoString(emailTxt1);
				contactMechs.add(partyContactMech);
				
				if(emails.size() > 1) {
					partyContactMech = emails.get(1);
				} else {
					partyContactMech = new ContactMechDTO();
				}
				String emailTxt2 = email2.getText();
				partyContactMech.setContactMechPurpose("DEFAULT");
				partyContactMech.setContactMechType("EMAIL");
				partyContactMech.setInfoString(emailTxt2);
				contactMechs.add(partyContactMech);
				
				dto.setContactMechDTOs(contactMechs);
				
				AddressDTO addressDTO = dto.getAddressDTO();
				if(addressDTO == null) {
					addressDTO = new AddressDTO();
				}
				
				addressDTO.setAddress1(address1.getText());
				addressDTO.setAddress2(address2.getText());
				addressDTO.setCity(city.getText());
				addressDTO.setStateProvince(state.getText());
				addressDTO.setCountry(country.getText());
				addressDTO.setPostalCode(zip.getText());
				dto.setAddressDTO(addressDTO);
				
				if(isNewMode()) {
					getFleetManagerServiceFacade().saveCustomer(dto);
					refreshFormData(dto);
					setFormMode(Mode.EDIT);
				} else if(isEditMode()) {
					Integer customerId = (Integer) namespace.get("CustomerId");
					dto.setPartyId(customerId);
					getFleetManagerServiceFacade().updateCustomer(dto);
				}
			}
			
		});
	}

	/**
	 * @param resultMap
	 */
	private void refreshFormData(CustomerDTO dto) {
		if(dto != null) {
			salutation.setSelectedItem(dto.getSalutation());
			firstName.setText(dto.getFirstName());
			middleName.setText(dto.getMiddleName());
			lastName.setText(dto.getLastName());
			birthDate.setSelectedDate(DateTimeUtil.toDateString(dto.getBirthDate(), "yyyy-MM-dd"));
			gender.setSelectedItem(dto.getGender());
			
			if(dto.getAddressDTO() != null) {
				AddressDTO addressDTO = dto.getAddressDTO();
				address1.setText(addressDTO.getAddress1());
				address2.setText(addressDTO.getAddress2());
				city.setText(addressDTO.getCity());
				state.setText(addressDTO.getStateProvince());
				zip.setText(addressDTO.getPostalCode());
				country.setText(addressDTO.getCountry());
			}
			
			List<ContactMechDTO> partyContactMechs = dto.getContactMechDTOs();
			
			List<ContactMechDTO> phones = new java.util.ArrayList<ContactMechDTO>();
			List<ContactMechDTO> emails = new java.util.ArrayList<ContactMechDTO>();
			
			
			if(partyContactMechs != null) {
				for (ContactMechDTO partyContactMech : partyContactMechs) {
					if(StringUtils.startsWith(partyContactMech.getContactMechType(),"PHONE_")) {
						phones.add(partyContactMech);
					} else if(StringUtils.equals(partyContactMech.getContactMechType(), "EMAIL")) {
						emails.add(partyContactMech);
					}
				}
			}
			
			if(!phones.isEmpty()) {
				if(phones.size() > 0) {
					ContactMechDTO contactMech = phones.get(0);
					phoneType1.setSelectedItem(StringUtils.substringAfter(contactMech.getContactMechType(), "PHONE_"));
					infoString1.setText(contactMech.getInfoString());
				}
				
				if(phones.size() > 1) {
					ContactMechDTO contactMech = phones.get(1);
					phoneType2.setSelectedItem(StringUtils.substringAfter(contactMech.getContactMechType(), "PHONE_"));
					infoString2.setText(contactMech.getInfoString());
				}
			}
			
			if(!emails.isEmpty()) {
				if(emails.size() > 0) {
					email1.setText(emails.get(0).getInfoString());
				}
				
				if(emails.size() > 1) {
					email2.setText(emails.get(1).getInfoString());
				}
			}
			
			saveButton.setButtonData("Update");
		}
		
	}

}
