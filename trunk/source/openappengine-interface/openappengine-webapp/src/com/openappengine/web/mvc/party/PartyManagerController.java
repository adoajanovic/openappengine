/**
 * 
 */
package com.openappengine.web.mvc.party;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.context.FacadeContext;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.facade.party.dto.AddressCommand;
import com.openappengine.facade.party.dto.PartyCommand;
import com.openappengine.facade.party.dto.PartyContactMechCommand;
import com.openappengine.model.code.CodeTypeConstants;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 *
 */
public class PartyManagerController extends BaseWebController {
	
	private PartyBean partyBean;
	
	private PartyContactMechBean partyContactMechBean;
	
	private PartyAddressBean addressBean;
	
	private List<PartyContactMechBean> contactMechs = new ArrayList<PartyContactMechBean>();
	
	private List<PartyAddressBean> partyAddresses = new ArrayList<PartyAddressBean>();
	
	private PartyManagerFacade partyManagerFacade;
	
	private boolean renderContactMechForm;
	
	private boolean renderAddressForm;
	
	public PartyManagerController() {
		partyManagerFacade = FacadeContext.getPartyManagerFacade();
	}
	
	public void addContactMech(ActionEvent actionEvent) {
		this.contactMechs.add(partyContactMechBean);
		
		renderContactMechForm = false;
	}
	
	public void openContactMechForm(ActionEvent actionEvent) {
		renderContactMechForm = true;
		partyContactMechBean = new PartyContactMechBean();
	}
	
	
	public String addAddress() {
		this.partyAddresses.add(addressBean);
		renderAddressForm = false;
		return null;
	}
	
	public void openAddressForm(ActionEvent actionEvent) {
		addressBean = new PartyAddressBean();
		renderAddressForm = true;
	}
	
	/**
	 * @return Perishable Types
	 */
	public List<SelectItem> getPartyTypes() {
		List<SelectItem> partyTypes = new ArrayList<SelectItem>();
		List<CodeDTO> list = partyManagerFacade.listAllCodes(CodeTypeConstants.PARTY_TYPE);
		if(list != null && !list.isEmpty()) {
			for (CodeDTO codeDTO : list) {
				partyTypes.add(new SelectItem(codeDTO.getValue(),codeDTO.getLabel(),codeDTO.getLabel()));
			}
		}
		return partyTypes;
	}
	
	public String createParty() {
		PartyCommand partyCommand = new PartyCommand(
				partyBean.getDescription(),
				partyBean.getPreferredCurrencyUom(), partyBean.getPartyType());
		if(contactMechs != null && !contactMechs.isEmpty()) {
			for (PartyContactMechBean contactMechBean : contactMechs) {
				PartyContactMechCommand partyContactMechCommand = new PartyContactMechCommand(
						contactMechBean.getContactMechPurpose(),
						contactMechBean.getContactMechType(),
						contactMechBean.getInfoString());
				partyCommand.addContactMech(partyContactMechCommand);
			}
		}
		
		if(partyAddresses != null && !partyAddresses.isEmpty()) {
			for (PartyAddressBean partyAddressBean : partyAddresses) {
				AddressCommand addressCommand = new AddressCommand();
				
				addressCommand.setAttnName(partyBean.getDescription());
				addressCommand.setToName(partyBean.getDescription());
				
				addressCommand.setAddress1(partyAddressBean.getAddress1());
				addressCommand.setAddress2(partyAddressBean.getAddress2());
				addressCommand.setCity(partyAddressBean.getCity());
				addressCommand.setCountry(partyAddressBean.getCountry());
				addressCommand.setDirections(partyAddressBean.getDirections());
				addressCommand.setPostalCode(partyAddressBean.getPostalCode());
				addressCommand.setPostalCodeExt(partyAddressBean.getPostalCodeExt());
				addressCommand.setStateProvince(partyAddressBean.getStateProvince());
				
				Set<String> roles = new HashSet<String>();
				roles.addAll(partyAddressBean.getRoles());
				addressCommand.setRoles(roles );
				
				partyCommand.addAddress(addressCommand);
			}
		}
		
		String partyId = partyManagerFacade.createParty(partyCommand);
		if(partyId != null) {
			
		}
		return null;
	}
	
	public void openContactMechPopup(ActionEvent e) {
		partyContactMechBean = new PartyContactMechBean();
	}
	
	public String addContact() {
		partyBean.addContactMech(partyContactMechBean);
		return null;
	}

	public PartyBean getPartyBean() {
		return partyBean;
	}
	
	public void setPartyBean(PartyBean partyBean) {
		this.partyBean = partyBean;
	}

	public PartyContactMechBean getPartyContactMechBean() {
		return partyContactMechBean;
	}

	public void setPartyContactMechBean(PartyContactMechBean partyContactMechBean) {
		this.partyContactMechBean = partyContactMechBean;
	}

	public PartyAddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(PartyAddressBean addressBean) {
		this.addressBean = addressBean;
	}

	public List<PartyContactMechBean> getContactMechs() {
		return contactMechs;
	}

	public void setContactMechs(List<PartyContactMechBean> contactMechs) {
		this.contactMechs = contactMechs;
	}

	public boolean isRenderContactMechForm() {
		return renderContactMechForm;
	}

	public void setRenderContactMechForm(boolean renderContactMechForm) {
		this.renderContactMechForm = renderContactMechForm;
	}

	public List<PartyAddressBean> getPartyAddresses() {
		return partyAddresses;
	}

	public void setPartyAddresses(List<PartyAddressBean> partyAddresses) {
		this.partyAddresses = partyAddresses;
	}

	public boolean isRenderAddressForm() {
		return renderAddressForm;
	}

	public void setRenderAddressForm(boolean renderAddressForm) {
		this.renderAddressForm = renderAddressForm;
	}

}
