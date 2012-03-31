/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.model.party.Address;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;

/**
 * @author hrishi
 *
 */
public class CustomerDTOAssembler {
	
	public CustomerDTO toDTO(Person person) {
		CustomerDTO customerDTO = new CustomerDTO();
		if(person == null) {
			return customerDTO;
		}
		
		customerDTO.setFirstName(person.getFirstName());
		customerDTO.setLastName(person.getLastName());
		customerDTO.setMiddleName(person.getMiddleName());
		customerDTO.setBirthDate(person.getBirthDate());
		customerDTO.setGender(person.getGender());
		customerDTO.setSalutation(person.getSalutation());
		customerDTO.setPartyId(person.getPartyId());
		customerDTO.setStatus(person.getStatus());
		
		List<PartyContactMech> partyContactMechs = person.getPartyContactMechs();
		
		List<ContactMechDTO> contactMechDTOs = new ArrayList<ContactMechDTO>();
		
		if(partyContactMechs != null) {
			ContactMechDTOAssembler contactMechDTOAssembler = new ContactMechDTOAssembler();
			for (PartyContactMech contactMech : partyContactMechs) {
				ContactMechDTO contactMechDTO = contactMechDTOAssembler.toDTO(contactMech);
				contactMechDTOs.add(contactMechDTO);
			}
		}
		customerDTO.setContactMechDTOs(contactMechDTOs);
		
		List<Address> addresses = person.getAddresses();
		if(addresses != null && !addresses.isEmpty()) {
			for (Address address : addresses) {
				AddressDTO addressDTO = new AddressDTOAssembler().toDTO(address);
				customerDTO.setAddressDTO(addressDTO);
				break;
			}
		}
		
		return customerDTO;
	}
	
	public Person fromDTO(CustomerDTO dto) {
		Person p = new Person();
		if(dto == null) {
			return p;
		}
		p.setPartyId(dto.getPartyId());
		p.setFirstName(dto.getFirstName());
		p.setMiddleName(dto.getMiddleName());
		p.setLastName(dto.getLastName());
		p.setBirthDate(dto.getBirthDate());
		p.setSalutation(dto.getSalutation());
		p.setGender(dto.getGender());
		p.setPartyType("PERSON");
		p.setStatus(dto.getStatus());
		
		List<ContactMechDTO> contactMechDTOs = dto.getContactMechDTOs();
		
		if(contactMechDTOs != null) {
			ContactMechDTOAssembler contactMechDTOAssembler = new ContactMechDTOAssembler();
			for (ContactMechDTO contactMech : contactMechDTOs) {
				PartyContactMech partyContactMech = contactMechDTOAssembler.fromDTO(contactMech);
				p.getPartyContactMechs().add(partyContactMech);
			}
		}
		
		AddressDTO addressDTO = dto.getAddressDTO();
		if(addressDTO != null) {
			Address address = new AddressDTOAssembler().fromDTO(addressDTO);
			String toName = p.getFirstName() + " " + p.getLastName();
			address.setToName(toName);
			address.setAttnName(toName);
			p.addAddress(address);
		}
		
		return p;
	}

}
