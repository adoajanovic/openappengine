/**
 * 
 */
package com.ms.openapps.dto.itemmaster;

import com.ms.openapps.dto.GenericDto;

/**
 * @author hrishi
 *
 */
public class FormItemMasterVO extends GenericDto {

	private static final long serialVersionUID = 1L;
	
	private ItemMasterVO itemMasterVO = new ItemMasterVO();

	public ItemMasterVO getItemMasterVO() {
		return itemMasterVO;
	}

	public void setItemMasterVO(ItemMasterVO itemMasterVO) {
		this.itemMasterVO = itemMasterVO;
	}

}
