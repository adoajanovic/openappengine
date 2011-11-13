/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;

import com.openappengine.model.addressbook.Address;
import com.openappengine.model.addressbook.AddressType;

/**
 * @author hrishi
 *
 */
public class AddressDTOAssembler {
	
	/**
	 * Create Address BO from DTO.
	 * @param addressCommand
	 * @return
	 */
	public Address fromDTO(AddressCommand addressCommand) {
		Address address = new Address();
		address.setAddress1(addressCommand.getAddress1());
		address.setAddress2(addressCommand.getAddress2());
		address.setAttnName(addressCommand.getAttnName());
		address.setCity(addressCommand.getCity());
		address.setStateProvince(addressCommand.getStateProvince());
		address.setCountry(addressCommand.getCountry());
		address.setDirections(addressCommand.getDirections());
		address.setPostalCode(addressCommand.getDirections());
		address.setPostalCodeExt(addressCommand.getPostalCodeExt());
		address.setToName(addressCommand.getToName());
		
		Set<String> roles = addressCommand.getRoles();
		for (String role : roles) {
			Date startDate = new Date();
			//TODO
			AddressType addressType = new AddressType(role, startDate, DateUtils.addYears(startDate, 100));
			address.addAddressType(addressType);
		}
		return address;
	}

}
