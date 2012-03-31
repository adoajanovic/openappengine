package com.openappengine.fms.interfaces.dto;

import com.openappengine.model.addressbook.Address;

public class AddressDTOAssembler {
	
	public AddressDTO toDTO(Address address) {
		AddressDTO dto = new AddressDTO();
		dto.setAddress1(address.getAddress1());
		dto.setAddress2(address.getAddress2());
		dto.setCity(address.getCity());
		dto.setCountry(address.getCountry());
		dto.setPostalCode(address.getPostalCode());
		dto.setStateProvince(address.getStateProvince());
		return dto;
	}
	
	public Address fromDTO(AddressDTO addressDTO) {
		Address address = new Address();
		address.setAddress1(addressDTO.getAddress1());
		address.setAddress2(addressDTO.getAddress2());
		address.setCity(addressDTO.getCity());
		address.setCountry(addressDTO.getCountry());
		address.setPostalCode(addressDTO.getPostalCode());
		address.setStateProvince(addressDTO.getStateProvince());
		return address;
	}

}
