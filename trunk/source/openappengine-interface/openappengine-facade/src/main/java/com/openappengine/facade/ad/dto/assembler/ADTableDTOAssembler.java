/**
 * 
 */
package com.openappengine.facade.ad.dto.assembler;

import java.util.List;

import org.apache.commons.lang.Validate;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public class ADTableDTOAssembler {
	
	public ADTableDTO toDTO(ADTable adTable) {
		if(adTable ==  null) {
			return null;
		}
		
		ADTableDTO adTableDTO = new ADTableDTO(adTable.getTableName());
		adTableDTO.setDeleteable(adTable.isDeleteable());
		adTableDTO.setDescription(adTable.getDescription());
		adTableDTO.setEntityClassName(adTable.getEntityClassName());
		adTableDTO.setHelpText(adTable.getHelpText());
		adTableDTO.setHighVolume(adTable.isHighVolume());
		adTableDTO.setImportable(adTable.isImportable());
		adTableDTO.setName(adTable.getName());
		adTableDTO.setWindow(adTable.getWindow());
		
		return adTableDTO;
	}
	
	public ADTable fromDTO(ADTableDTO adTableDTO) {
		if(adTableDTO == null) {
			return null;
		}
		
		Validate.notEmpty(adTableDTO.getName());
		
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
				Validate.notEmpty(adColumnDTO.getName());
				
				ADColumn adColumn = new ADColumn();
				adColumn.setColumnName(adColumnDTO.getColumnName());
				adColumn.setDescription(adColumnDTO.getDescription());
				adColumn.setHelpText(adColumnDTO.getHelpText());
				adColumn.setKey(adColumnDTO.isKey());
				adColumn.setMandatory(adColumnDTO.isMandatory());
				adColumn.setName(adColumnDTO.getName());
				adColumn.setSelectionColumn(adColumnDTO.isSelectionColumn());
				adColumn.setUpdateable(adColumnDTO.isUpdateable());
				adColumn.setAdTable(adTable);
				adTable.addAdColumn(adColumn);
			}
		}
		return adTable;
	}

}
