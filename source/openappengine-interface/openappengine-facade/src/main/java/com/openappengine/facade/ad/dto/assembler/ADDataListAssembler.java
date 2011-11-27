/**
 * 
 */
package com.openappengine.facade.ad.dto.assembler;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.ad.dto.ADListItemDTO;
import com.openappengine.model.ad.ADDataList;

/**
 * @author hrishi
 * 
 */
public class ADDataListAssembler {

    public List<ADListItemDTO> toDTOList(List<ADDataList> adDataList) {
	List<ADListItemDTO> adListItemDTOs = new ArrayList<ADListItemDTO>();
	if (adDataList != null) {
	    for (ADDataList adData : adDataList) {
		ADListItemDTO dto = new ADListItemDTO();
		dto.setLabel(adData.getLabel());
		dto.setValue(adData.getValue());
	    }
	}
	return adListItemDTOs;
    }

}
