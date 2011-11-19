/**
 * 
 */
package com.openappengine.facade.ad.dto.assembler;

import java.util.List;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public class ADTableDTOAssembler {
	
	public ADTable fromDTO(ADTableDTO adTableDTO) {
		if(adTableDTO == null) {
			return null;
		}
		
		ADTable adTable = new ADTable();
		adTable.setDeleteable(adTableDTO.isDeleteable());
		adTable.setDescription(adTableDTO.getDescription());
		adTable.setEntityClassName(adTableDTO.getEntityClassName());
		adTable.setHelpText(adTableDTO.getHelpText());
		adTable.setHighVolume(adTableDTO.isHighVolume());
		adTable.setImportable(adTableDTO.isImportable());
		adTable.setName(adTableDTO.getName());
		adTable.setTableName(adTableDTO.getTableName());
		adTable.setWindow(adTableDTO.getWindow());
		
		List<ADColumnDTO> adColumnDTOs = adTableDTO.getAdColumnDTOs();
		if(adColumnDTOs != null && !adColumnDTOs.isEmpty()) {
			for (ADColumnDTO adColumnDTO : adColumnDTOs) {
				ADColumn adColumn = new ADColumn();
				adColumn.setColumnName(adColumnDTO.getColumnName());
				adColumn.setDescription(adColumnDTO.getDescription());
				adColumn.setHelpText(adColumnDTO.getHelpText());
				adColumn.setKey(adColumnDTO.isKey());
				adColumn.setMandatory(adColumnDTO.isMandatory());
				adColumn.setName(adColumnDTO.getName());
				adColumn.setSelectionColumn(adColumnDTO.isSelectionColumn());
				adColumn.setUpdateable(adColumnDTO.isUpdateable());
				adTable.addAdColumn(adColumn);
			}
		}
		return adTable;
	}

}
