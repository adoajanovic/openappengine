package com.openappengine.facade.ad.dto.assembler;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.model.ad.ADColumn;

public class ADColumnDTOAssembler {
	
	public ADColumnDTO toDTO(ADColumn adColumn) {
		if(adColumn == null) {
			return null;
		}
		ADColumnDTO adColumnDTO = new ADColumnDTO(adColumn.getColumnName());
		adColumnDTO.setDescription(adColumn.getDescription());
		adColumnDTO.setHelpText(adColumn.getHelpText());
		adColumnDTO.setKey(adColumn.isKey());
		adColumnDTO.setMandatory(adColumn.isMandatory());
		adColumnDTO.setName(adColumn.getName());
		adColumnDTO.setSelectionColumn(adColumn.isSelectionColumn());
		adColumnDTO.setUpdateable(adColumn.isUpdateable());
		return adColumnDTO;
	}

}
