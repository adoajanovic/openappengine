package com.openappengine.fms.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.openappengine.fms.interfaces.dto.ContactMechDTO;
import com.openappengine.fms.interfaces.dto.ContactMechDTOAssembler;
import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.CustomerDTOAssembler;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;
import com.openappengine.repository.RepositoryUtils;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
	
/**
 * 
 * @author hrishi
 */
public class FleetManagerServiceFacadeImpl implements FleetManagerServiceFacade {
	
	private ServiceDispatcher serviceDispatcher;
	
	public FleetManagerServiceFacadeImpl() {
		serviceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
	}

	@Override
	public CustomerDTO loadCustomerDTO(Integer partyId) {
		RepositoryUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Person person;
		try {
			context.put("personId", partyId);
			resultMap = serviceDispatcher.runSync("party.findPersonById", context);
		} catch (ServiceException e) {
			person = null;
		}
		
		person = (Person) resultMap.get("person");
		
		List<PartyContactMech> partyContactMechs = person.getPartyContactMechs();
		partyContactMechs.toString();
		
		CustomerDTOAssembler assembler = new CustomerDTOAssembler();
		CustomerDTO dto = assembler.toDTO(person);
		
		RepositoryUtils.closeOpenSession();
		return dto;
	}

	@Override
	public void saveCustomer(CustomerDTO dto) {
		RepositoryUtils.openSession();
		String serviceName = "";
		serviceName = "party.createPerson";
		Person person = new CustomerDTOAssembler().fromDTO(dto);
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new HashMap<String, Object>();
		context.put("person", person);
		
		List<PartyContactMech> contactMechs = new ArrayList<PartyContactMech>(); 
		List<ContactMechDTO> contactMechDTOs = dto.getContactMechDTOs();
		if(contactMechDTOs != null) {
			for (ContactMechDTO contactMechDTO : contactMechDTOs) {
				contactMechs.add(new ContactMechDTOAssembler().fromDTO(contactMechDTO));
			}
		}
		context.put("partyContactMechs", contactMechs);
		try {
			sd.runSync(serviceName, context);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		RepositoryUtils.closeOpenSession();
	}
	
	@Override
	public void updateCustomer(CustomerDTO dto) {
		Session session = RepositoryUtils.openSession();
		String serviceName = "";
		serviceName = "party.updatePerson";
		Person person = new CustomerDTOAssembler().fromDTO(dto);
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new HashMap<String, Object>();
		List<ContactMechDTO> contactMechDTOs = dto.getContactMechDTOs();
		
		List<PartyContactMech> contactMechs = new ArrayList<PartyContactMech>(); 
		if(contactMechDTOs != null) {
			for (ContactMechDTO contactMechDTO : contactMechDTOs) {
				contactMechs.add(new ContactMechDTOAssembler().fromDTO(contactMechDTO));
			}
		}
		context.put("person", person);
		context.put("partyContactMechs", contactMechs);
		try {
			sd.runSync(serviceName, context);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		RepositoryUtils.closeOpenSession();
	}

	@Override
	public List<CustomerDTO> loadActiveCustomerDTOs() {
		RepositoryUtils.openSession();
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new java.util.HashMap<String, Object>();
		
		java.util.Map<String, Object> resultMap = new java.util.HashMap<String, Object>();
		try {
			resultMap = sd.runSync("party.getActiveParties", context);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>) resultMap.get("personPartyList");
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		if(personList != null) {
			CustomerDTOAssembler assembler = new CustomerDTOAssembler();
			for (Person person : personList) {
				CustomerDTO dto = assembler.toDTO(person);
				customerDTOs.add(dto);
			}
		}
		RepositoryUtils.closeOpenSession();
		return customerDTOs;
	}
}
