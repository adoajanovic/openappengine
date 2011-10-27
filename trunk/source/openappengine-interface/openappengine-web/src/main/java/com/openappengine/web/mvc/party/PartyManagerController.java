/**
 * 
 */
package com.openappengine.web.mvc.party;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.context.FacadeContext;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.facade.party.dto.PartyCommand;
import com.openappengine.model.code.CodeTypeConstants;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 *
 */
public class PartyManagerController extends BaseWebController {
	
	private PartyModel partyModel;
	
	private PartyManagerFacade partyManagerFacade;
	
	public PartyManagerController() {
		partyManagerFacade = FacadeContext.getPartyManagerFacade();
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
		partyManagerFacade.createParty(new PartyCommand(partyModel.getDescription(), partyModel.getPreferredCurrencyUom(), partyModel.getPartyType(), null));
		return null;
	}

	public PartyModel getPartyModel() {
		return partyModel;
	}
	
	public void setPartyModel(PartyModel partyModel) {
		this.partyModel = partyModel;
	}

}
